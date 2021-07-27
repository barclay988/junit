package com.psybergate.vacwork2021.tax.income;

import java.math.BigDecimal;

public class Income {

  private  BigDecimal salary;

  private  BigDecimal interestReceived;

  private  BigDecimal totalCapitalGains;
  private  BigDecimal bonus;



  public Income() {

  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public void setBonus(BigDecimal bonus) {
    this.bonus = bonus;
  }

  public   void setInterestReceived(BigDecimal interestReceived) {
    this.interestReceived = interestReceived;
  }

  public void setTotalCapitalGains(BigDecimal totalCapitalGains) {
    this.totalCapitalGains = totalCapitalGains;
  }

  public  BigDecimal getSalary() {
    return salary;
  }

  public  BigDecimal getBonus() {
    return bonus;
  }

  public  BigDecimal getInterestReceived() {
    return interestReceived;
  }

  public  BigDecimal getTotalCapitalGains() {
    return totalCapitalGains;
  }

}
