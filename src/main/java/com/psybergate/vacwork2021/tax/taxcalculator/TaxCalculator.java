package com.psybergate.vacwork2021.tax.taxcalculator;

import com.psybergate.vacwork2021.tax.constant.Constant;
import com.psybergate.vacwork2021.tax.taxtable.TaxTable;

import java.math.BigDecimal;


public class TaxCalculator {


  private static TaxTable taxTable;


  public TaxCalculator() {
  }

  public BigDecimal calculateTravelAllowance(BigDecimal travelAllowance) {

    if (travelAllowance.compareTo(Constant.TRAVEL_ALLOWANCE_EXEMPTION)<0) {
      return travelAllowance;
    } else {
      return Constant.TRAVEL_ALLOWANCE_EXEMPTION;
    }
  }


  public BigDecimal calculateRetirementFund(BigDecimal retirementFund) {
    if (retirementFund.compareTo(Constant.RETIREMENT_FUND_EXEMPTION)<0) {
      return retirementFund;
    } else {
      return Constant.RETIREMENT_FUND_EXEMPTION;
    }

  }


  public BigDecimal calculateTotalExpenses(BigDecimal retirementFund, BigDecimal travelAllowance) {
    return calculateRetirementFund(retirementFund).add(calculateTravelAllowance(travelAllowance));
  }


  public  BigDecimal calculateTotalIncome(BigDecimal salary, BigDecimal bonus, BigDecimal interestReceived,
                                                BigDecimal totalCapitalGains) {

    return salary.add(bonus).add(calculateInterestReceived(interestReceived).add(calculateCapitalGains(totalCapitalGains))).setScale(0, BigDecimal.ROUND_HALF_UP);

  }

  public  BigDecimal calculateInterestReceived(BigDecimal interestReceived) {

    BigDecimal zero = new BigDecimal(0.0);
    if ((interestReceived.subtract(Constant.INTEREST_EXEMPTION_AMOUNT)).compareTo(zero) < 0) {
      return zero;
    } else {
      return interestReceived.subtract(Constant.INTEREST_EXEMPTION_AMOUNT);
    }

  }

  public  BigDecimal calculateCapitalGains(BigDecimal totalCapitalGains) {

    BigDecimal zero = new BigDecimal(0.0);
    if (totalCapitalGains.compareTo(Constant.CAPITAL_GAINS_EXEMPTION_AMOUNT) < 0) {
      return zero;
    } else {
      return (totalCapitalGains.subtract(Constant.CAPITAL_GAINS_EXEMPTION_AMOUNT)).multiply(Constant.CAPITAL_GAINS_RATE).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

  }


  public BigDecimal calculateTotalCredits(BigDecimal medicalCredits, BigDecimal primaryRebate) {

    return calculateMedicalCredits(medicalCredits).add(primaryRebate) ;
  }


  public BigDecimal calculateMedicalCredits(BigDecimal medicalCredits) {
    if (medicalCredits.compareTo(Constant.MAX_MEDICAL_CREDITS) < 0) {
      return medicalCredits;
    } else {
      return Constant.MAX_MEDICAL_CREDITS;
    }
  }

  //optimize code
  public  BigDecimal payableTax(BigDecimal netTaxableIncome) {
    BigDecimal taxableIncome = new BigDecimal("0.0");
    BigDecimal totalTaxableAmount = new BigDecimal("0.0");
    for (int i = 0; i < 7; i++) {
      taxableIncome = (netTaxableIncome.min(taxTable.getUpperBounds().get(i).subtract(taxTable.getLowerBounds().get(i))));
      totalTaxableAmount = totalTaxableAmount.add(taxableIncome.multiply(taxTable.getRates().get(i)));
      netTaxableIncome = netTaxableIncome.subtract(taxableIncome);
    }
    return totalTaxableAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
  }



  public BigDecimal netTaxPayableTax(BigDecimal totalCredits, BigDecimal taxPayable) {

    return taxPayable.subtract(totalCredits).setScale(2, BigDecimal.ROUND_HALF_UP);
  }

}
