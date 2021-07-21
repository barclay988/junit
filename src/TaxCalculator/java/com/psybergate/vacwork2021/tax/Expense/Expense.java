package com.psybergate.vacwork2021.tax.Expense;
import java.math.BigDecimal;

public class Expense {

  private static BigDecimal RETIREMENT_FUND_EXEMPTION = new BigDecimal(144375.00) ;

  private static BigDecimal TRAVEL_ALLOWANCE_EXEMPTION = new BigDecimal(80000.00);

  private BigDecimal retirementFund;

  private BigDecimal travelAllowance;

  public Expense(BigDecimal retirementFund, BigDecimal travelAllowance) {

    this.retirementFund = retirementFund;
    this.travelAllowance = travelAllowance;
  }
  public Expense(){

  }

  public BigDecimal calculateTravelAllowance(BigDecimal travelAllowance) {

    if (travelAllowance.compareTo(TRAVEL_ALLOWANCE_EXEMPTION)<0) {
      return travelAllowance;
    } else {
      return TRAVEL_ALLOWANCE_EXEMPTION;
    }
  }

  public BigDecimal calculateRetirementFund(BigDecimal retirementFund) {
    if (retirementFund.compareTo(RETIREMENT_FUND_EXEMPTION)<0) {
      return retirementFund;
    } else {
      return RETIREMENT_FUND_EXEMPTION;
    }

  }

  public BigDecimal calculateTotalExpenses(BigDecimal retirementFund, BigDecimal travelAllowance) {
    return calculateRetirementFund(retirementFund).add(calculateTravelAllowance(travelAllowance));
  }

  public BigDecimal getRetirementFund() {
    return retirementFund;
  }

  public BigDecimal getTravelAllowance() {
    return travelAllowance;
  }

}
