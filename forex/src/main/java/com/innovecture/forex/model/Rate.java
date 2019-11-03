package com.innovecture.forex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;
  private String base;
  private String currency;
  private Double currencyRate;
  private String date;

  public Rate() {
  }

  public Rate(String base, String currency, Double currencyRate, String date) {

    this.base = base;
    this.currency = currency;
    this.currencyRate = currencyRate;
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getCurrencyRate() {
    return currencyRate;
  }

  public void setCurrencyRate(Double currencyRate) {
    this.currencyRate = currencyRate;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Rate{" +
        "id=" + id +
        ", base='" + base + '\'' +
        ", currency='" + currency + '\'' +
        ", currencyRate=" + currencyRate +
        ", date='" + date + '\'' +
        '}';
  }
}
