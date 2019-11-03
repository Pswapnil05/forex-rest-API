package com.innovecture.forex.model;


public class ForexBean {

  private String base;
  private String to;
  private Double exchange_rate;
  private Double quantity;
  private Double total_amount;
  private String date;

  public ForexBean() {
  }

  public ForexBean(String base, String to, Double exchange_rate, Double quantity,
                   Double total_amount, String date) {
    this.base = base;
    this.to = to;
    this.exchange_rate = exchange_rate;
    this.quantity = quantity;
    this.total_amount = total_amount;
    this.date = date;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Double getExchange_rate() {
    return exchange_rate;
  }

  public void setExchange_rate(Double exchange_rate) {
    this.exchange_rate = exchange_rate;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getTotal_amount() {
    return total_amount;
  }

  public void setTotal_amount(Double total_amount) {
    this.total_amount = total_amount;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "ForexBean{" + " quantity= " + quantity+" "+base +
        ", total_amount= " + total_amount+" "+to  +'}';
  }
}
