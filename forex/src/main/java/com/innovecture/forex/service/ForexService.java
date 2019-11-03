package com.innovecture.forex.service;

import com.innovecture.forex.model.ForexBean;
import com.innovecture.forex.model.Rate;
import com.innovecture.forex.repository.RateRepository;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ForexService {
  private final Logger logger = LoggerFactory.getLogger(ForexService.class);
  HashSet<String> uniqueBase = new HashSet<>();

  @Autowired
  private RateRepository rateRepository;

  public ResponseEntity<ForexBean> getForexRates(String base, String to, Double quantity) {
    logger.info("INFO MESSAGE -- Through Service Component Currency Conversion Method has been Invoked");
    uniqueBaseUpload(base);
    logger.info("INFO MESSAGE -- Finding Required Rate Object in Rate Table by 'base' and 'currency' Column");
    Rate rate = rateRepository.findByBaseAndCurrency(base, to);
    loggerOutputDisplay(rate,quantity,base,to);
    return new ResponseEntity<ForexBean>(new ForexBean(base,to,rate.getCurrencyRate(),
        quantity,quantity*rate.getCurrencyRate(),rate.getDate()), HttpStatus.OK);
  }

  private void loggerOutputDisplay(Rate rate, Double quantity, String base, String to) {
    logger.info("{}",rate);
    logger.info("INFO MESSAGE -- Displaying required Output of Currency Convertor");
    logger.info("{}",new ForexBean(base,to,rate.getCurrencyRate(),
        quantity,quantity*rate.getCurrencyRate(),rate.getDate()));

  }

  private void baseDatabase(String base) {
    logger.info("INFO MESSAGE -- Uploading Unique Base Currency API in DB If Base Currency does'nt exist in HashSet");
    String date;
    String currency;
    Double currencyRate;
    String query_url = "https://api.exchangerate-api.com/v4/latest/"+base;

    try {
      URL url = new URL(query_url);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setConnectTimeout(5000);
      conn.setDoInput(true);
      conn.setDoOutput(true);

      //read the response
      InputStream in = new BufferedInputStream(conn.getInputStream());
      String results = IOUtils.toString(in, "UTF-8");

      //convert to jsonObject
      JSONObject response = new JSONObject(results);
      date = response.getString("date");

      //Retrieving the array
      JSONObject rates = (JSONObject) response.get("rates");

      JSONArray keys = rates.names();
      for (int i=0; i<keys.length();++i) {
        currency = keys.getString(i);
        currencyRate = rates.getDouble(currency);
        rateRepository.save(new Rate(base,currency,currencyRate,date));
      }
      in.close();
      conn.disconnect();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void uniqueBaseUpload(String base) {
    logger.info("INFO MESSAGE -- Checking Whether Unique Base Currency exist in HashSet or not");
    if (uniqueBase.contains(base)) {
      logger.info("INFO MESSAGE -- {} currency conversion API Already exists in DB",base); }
    else {
      baseDatabase(base);
      logger.info("INFO MESSAGE -- Adding Unique Base Currency in HashSet");
      uniqueBase.add(base);
    }

  }

}
