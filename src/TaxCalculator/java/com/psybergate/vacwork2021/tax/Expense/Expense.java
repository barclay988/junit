package com.psybergate.vacwork2021.tax.Expense;

public class Expense {

  private static double RETIREMENT_FUND_EXEMPTION = 144375.00;

  private static double TRAVEL_ALLOWANCE_EXEMPTION = 80000.00;

  private double retirementFund;

  private double travelAllowance;

  public Expense(double retirementFund, double travelAllowance) {

    this.retirementFund = retirementFund;
    this.travelAllowance = travelAllowance;
  }
  public Expense(){

  }

  public double calculateTravelAllowance(double travelAllowance) {

    if (travelAllowance < TRAVEL_ALLOWANCE_EXEMPTION) {
      return travelAllowance;
    } else {
      return TRAVEL_ALLOWANCE_EXEMPTION;
    }
  }

  public double calculateRetirementFund(double retirementFund) {
    if (retirementFund < RETIREMENT_FUND_EXEMPTION) {
      return retirementFund;
    } else {
      return RETIREMENT_FUND_EXEMPTION;
    }

  }

  public double calculateTotalExpenses(double retirementFund, double travelAllowance) {
    return calculateRetirementFund(retirementFund) + calculateTravelAllowance(travelAllowance);
  }

  public double getRetirementFund() {
    return retirementFund;
  }

  public double getTravelAllowance() {
    return travelAllowance;
  }

}
