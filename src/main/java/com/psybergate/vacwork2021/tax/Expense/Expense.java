package com.psybergate.vacwork2021.tax.Expense;
import java.math.BigDecimal;

public class Expense {

  private BigDecimal retirementFund;

  private BigDecimal travelAllowance;

  public Expense(){

  }

  public void setRetirementFund(BigDecimal retirementFund) {
    this.retirementFund = retirementFund;
  }

  public void setTravelAllowance(BigDecimal travelAllowance) {
    this.travelAllowance = travelAllowance;
  }

  public BigDecimal getRetirementFund() {
    return retirementFund;
  }

  public BigDecimal getTravelAllowance() {
    return travelAllowance;
  }

}
