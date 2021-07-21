package com.psybergate.vacwork2021.tax.income;

public class Income {

  private static double INTEREST_EXEMPTION_AMOUNT = 23800.00;

  private static double CAPITAL_GAINS_RATE = 0.4;

  private static double CAPITAL_GAINS_EXEMPTION_AMOUNT = 40000.00;

  private double salary;

  private double bonus;

  private double interestReceived;

  private double totalCapitalGains;

  public Income(double salary, double bonus, double interestReceived, double totalCapitalGains) {

    this.salary = salary;
    this.bonus = bonus;
    this.interestReceived = interestReceived;
    this.totalCapitalGains = totalCapitalGains;

  }
  public Income(){

  }

  public static double calculateTotalIncome(double salary, double bonus, double interestReceived,
                                            double totalCapitalGains) {

    return salary + bonus + calculateInterestReceived(interestReceived) + calculateCapitalGains(totalCapitalGains);

  }

  public static double calculateInterestReceived(double interestReceived) {

    if ((interestReceived - INTEREST_EXEMPTION_AMOUNT) < 0) {
      return 0.0;
    } else {
      return interestReceived - INTEREST_EXEMPTION_AMOUNT;
    }

  }

  public static double calculateCapitalGains(double totalCapitalGains) {

    if (totalCapitalGains < CAPITAL_GAINS_EXEMPTION_AMOUNT) {
      return 0.0;
    } else {
      return (totalCapitalGains - CAPITAL_GAINS_EXEMPTION_AMOUNT) * CAPITAL_GAINS_RATE;
    }

  }

  public double getSalary() {
    return salary;
  }

  public double getBonus() {
    return bonus;
  }

  public double getInterestReceived() {
    return interestReceived;
  }

  public double getTotalCapitalGains() {
    return totalCapitalGains;
  }

}
