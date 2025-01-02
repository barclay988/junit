package com.psybergate.vacwork2021.tax.income;
import java.math.BigDecimal;
public class Income {

  private static  BigDecimal INTEREST_EXEMPTION_AMOUNT = new BigDecimal(23800.00);

  private static BigDecimal CAPITAL_GAINS_RATE = new BigDecimal(0.4);

  private static BigDecimal CAPITAL_GAINS_EXEMPTION_AMOUNT = new BigDecimal(40000.00);

  private BigDecimal salary;

  private BigDecimal bonus;

  private BigDecimal interestReceived;

  private BigDecimal totalCapitalGains;

  public Income(BigDecimal salary, BigDecimal bonus, BigDecimal interestReceived, BigDecimal totalCapitalGains) {

    this.salary = salary;
    this.bonus = bonus;
    this.interestReceived = interestReceived;
    this.totalCapitalGains = totalCapitalGains;

  }
  public Income(){

  }

  public static BigDecimal calculateTotalIncome(BigDecimal salary, BigDecimal bonus, BigDecimal interestReceived,
                                                BigDecimal totalCapitalGains) {

    return salary.add(bonus).add(calculateInterestReceived(interestReceived).add(calculateCapitalGains(totalCapitalGains))).setScale(0, BigDecimal.ROUND_HALF_UP);

  }

  public static BigDecimal calculateInterestReceived(BigDecimal interestReceived) {

    BigDecimal zero = new BigDecimal(0.0);
    if ((interestReceived.subtract(INTEREST_EXEMPTION_AMOUNT)).compareTo(zero) < 0) {
      return zero;
    } else {
      return interestReceived.subtract(INTEREST_EXEMPTION_AMOUNT);
    }

  }

  public static BigDecimal calculateCapitalGains(BigDecimal totalCapitalGains) {

    BigDecimal zero = new BigDecimal(0.0);
    if (totalCapitalGains.compareTo(CAPITAL_GAINS_EXEMPTION_AMOUNT) < 0) {
      return zero;
    } else {
      return (totalCapitalGains.subtract(CAPITAL_GAINS_EXEMPTION_AMOUNT)).multiply(CAPITAL_GAINS_RATE).setScale(0, BigDecimal.ROUND_HALF_UP);
    }

  }

  public BigDecimal getSalary() {
    return salary;
  }

  public BigDecimal getBonus() {
    return bonus;
  }

  public BigDecimal getInterestReceived() {
    return interestReceived;
  }

  public BigDecimal getTotalCapitalGains() {
    return totalCapitalGains;
  }

}
