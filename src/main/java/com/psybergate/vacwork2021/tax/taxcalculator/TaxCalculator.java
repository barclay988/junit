package com.psybergate.vacwork2021.tax.taxcalculator;

import com.psybergate.vacwork2021.tax.constant.Constant;

import java.math.BigDecimal;

public class TaxCalculator {
    private Constant constant;
  public TaxCalculator() {
  }

  //Epenses
  public BigDecimal calculateTravelAllowance(BigDecimal travelAllowance) {

    if (travelAllowance.compareTo(constant.TRAVEL_ALLOWANCE_EXEMPTION) < 0) {
      return travelAllowance;
    } else {
      return constant.TRAVEL_ALLOWANCE_EXEMPTION;
    }
  }
  //Epenses
  public BigDecimal calculateRetirementFund(BigDecimal retirementFund) {
    if (retirementFund.compareTo(Constant.RETIREMENT_FUND_EXEMPTION) < 0) {
      return retirementFund;
    } else {
      return constant.RETIREMENT_FUND_EXEMPTION;
    }

  }
  //Epenses
  public BigDecimal calculateTotalExpenses(BigDecimal retirementFund, BigDecimal travelAllowance) {
    return calculateRetirementFund(retirementFund).add(calculateTravelAllowance(travelAllowance));
  }
  //income
  public BigDecimal calculateTotalIncome(BigDecimal salary, BigDecimal bonus, BigDecimal interestReceived,
                                         BigDecimal totalCapitalGains) {

    return salary.add(bonus)
                 .add(calculateInterestReceived(interestReceived).add(calculateCapitalGains(totalCapitalGains)))
                 .setScale(0, BigDecimal.ROUND_HALF_UP);

  }

  //income
  public BigDecimal calculateInterestReceived(BigDecimal interestReceived) {

    BigDecimal zero = new BigDecimal("0.00");
    if ((interestReceived.subtract(constant.INTEREST_EXEMPTION_AMOUNT)).compareTo(zero) < 0) {
      return zero;
    } else {
      return interestReceived.subtract(constant.INTEREST_EXEMPTION_AMOUNT);
    }

  }
  //income
  public BigDecimal calculateCapitalGains(BigDecimal totalCapitalGains) {

    BigDecimal zero = new BigDecimal("0.00");
    if (totalCapitalGains.compareTo(constant.CAPITAL_GAINS_EXEMPTION_AMOUNT) < 0) {
      return zero;
    } else {
      return (totalCapitalGains.subtract(constant.CAPITAL_GAINS_EXEMPTION_AMOUNT)).multiply(constant.CAPITAL_GAINS_RATE).setScale(0,BigDecimal.ROUND_HALF_UP);
    }

  }
  //Credits
  public BigDecimal calculateTotalCredits(BigDecimal medicalCredits, BigDecimal primaryRebate) {

    return calculateMedicalCredits(medicalCredits).add(primaryRebate);
  }
  //Credits
  public BigDecimal calculateMedicalCredits(BigDecimal medicalCredits) {
    if (medicalCredits.compareTo(constant.MAX_MEDICAL_CREDITS) < 0) {
      return medicalCredits;
    } else {
      return constant.MAX_MEDICAL_CREDITS;
    }
  }

  public BigDecimal payableTax(BigDecimal netTaxableIncome) {

    BigDecimal taxableIncome = new BigDecimal("0.00");
    BigDecimal totalTaxableAmount = new BigDecimal("0.00");
    for (int i = 0; i < 7; i++) {
      taxableIncome = (netTaxableIncome.min(constant.TAX_UPPER_BOUND[i].subtract(constant.TAX_LOWER_BOUND[i])));
      totalTaxableAmount = totalTaxableAmount.add(taxableIncome.multiply(constant.TAX_RATES[i]));
      netTaxableIncome = netTaxableIncome.subtract(taxableIncome);
    }
    return totalTaxableAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal netTaxPayableTax(BigDecimal totalCredits, BigDecimal taxPayable) {

    return taxPayable.subtract(totalCredits).setScale(0, BigDecimal.ROUND_HALF_UP);
  }

}
