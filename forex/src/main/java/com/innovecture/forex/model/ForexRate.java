//package com.innovecture.forex.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//public class ForexRate {
//
//  @Id
//  @Column(name = "exchange_base")
//  private String base;
//  private Date date;
//  private Timestamp time_last_updated;
//  @OneToMany
//  private List<Rate> rates;
//
//  public ForexRate() {
//  }
//
//  public ForexRate(String base, Date date, Timestamp time_last_updated, List<Rate> rates) {
//    this.base = base;
//    this.date = date;
//    this.time_last_updated = time_last_updated;
//    this.rates = rates;
//  }
//
//  public String getBase() {
//    return base;
//  }
//
//  public void setBase(String base) {
//    this.base = base;
//  }
//
//  public Date getDate() {
//    return date;
//  }
//
//  public void setDate(Date date) {
//    this.date = date;
//  }
//
//  public Timestamp getTime_last_updated() {
//    return time_last_updated;
//  }
//
//  public void setTime_last_updated(Timestamp time_last_updated) {
//    this.time_last_updated = time_last_updated;
//  }
//
//  public List<Rate> getRates() {
//    return rates;
//  }
//
//  public void setRates(List<Rate> rates) {
//    this.rates = rates;
//  }
//}
