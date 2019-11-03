package com.innovecture.forex.controller;


import com.innovecture.forex.model.ForexBean;
import com.innovecture.forex.model.Rate;
import com.innovecture.forex.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ForexController {

  private final Logger logger = LoggerFactory.getLogger(ForexController.class);

  @Autowired
  private ForexService forexService;

  @RequestMapping("/forexRate/base/{base}/to/{to}/quantity/{quantity}")
  public ResponseEntity<ForexBean> getForexRates(@PathVariable String base,
                   @PathVariable String to, @PathVariable Double quantity) {
    logger.info("INFO MESSAGE -- Through RestController Component Currency Conversion Method has been Invoked");
    return forexService.getForexRates(base,to,quantity);
  }

}
