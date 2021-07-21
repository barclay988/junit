package com.psybergate.vacwork2021.tax.taxtable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxTable {

  ArrayList<BigDecimal> lowerBounds = new ArrayList<BigDecimal>(7);

  BigDecimal firstLowerBound = new BigDecimal("0.00");

  BigDecimal secondLowerBound = new BigDecimal("216200.00");

  BigDecimal thirdLowerBound = new BigDecimal("337801.00");

  BigDecimal fourthLowerBound = new BigDecimal("467501.00");

  BigDecimal fiveLowerBound = new BigDecimal("613601.00");

  BigDecimal sixthLowerBound = new BigDecimal("782201.00");

  BigDecimal seventhLowerBound = new BigDecimal("1656601.00");

  ArrayList<BigDecimal> upperBounds = new ArrayList<BigDecimal>(7);

  BigDecimal firstUpperBound = new BigDecimal("216200.00");

  BigDecimal secondUpperBound = new BigDecimal("337800.00");

  BigDecimal thirdUpperBound = new BigDecimal("467500.00");

  BigDecimal fourthUpperBound = new BigDecimal("613600.00");

  BigDecimal fiveUpperBound = new BigDecimal("782200.00");

  BigDecimal sixthUpperBound = new BigDecimal("1656600.00");

  BigDecimal seventhUpperBound = new BigDecimal("100000000.00");


  public TaxTable() {

  }





  public void setLowerBounds() {
    lowerBounds.add(firstLowerBound);
    lowerBounds.add(secondLowerBound);
    lowerBounds.add(thirdLowerBound);
    lowerBounds.add(fourthLowerBound);
    lowerBounds.add(fiveLowerBound);
    lowerBounds.add(sixthLowerBound);
    lowerBounds.add(seventhLowerBound);
  }




  public void setUpperBounds() {
    upperBounds.add(firstUpperBound);
    upperBounds.add(secondUpperBound);
    upperBounds.add(thirdUpperBound);
    upperBounds.add(fourthUpperBound);
    upperBounds.add(fiveUpperBound);
    upperBounds.add(sixthUpperBound);
    upperBounds.add(seventhUpperBound);
  }

  ArrayList<BigDecimal> rates = new ArrayList<BigDecimal>(7);

  BigDecimal firstRate = new BigDecimal("0.18");

  BigDecimal secondRate = new BigDecimal("0.26");

  BigDecimal thirdRate = new BigDecimal("0.31");

  BigDecimal fourthRate = new BigDecimal("0.36");

  BigDecimal fiveRate = new BigDecimal("0.39");

  BigDecimal sixthRate = new BigDecimal("0.41");

  BigDecimal seventhRate = new BigDecimal("0.45");

  public void setRates() {
    rates.add(firstRate);
    rates.add(secondRate);
    rates.add(thirdRate);
    rates.add(fourthRate);
    rates.add(fiveRate);
    rates.add(sixthRate);
    rates.add(seventhRate);
  }

  public BigDecimal payableTax(BigDecimal netTaxableIncome) {//break into smaller pieces
    BigDecimal taxableIncome = new BigDecimal("0.00");
    BigDecimal totalTaxableAmount = new BigDecimal("0.00");
    for (int i = 0; i < 7; i++) {
      taxableIncome = (netTaxableIncome.min(this.upperBounds.get(i).subtract(this.lowerBounds.get(i))));
      totalTaxableAmount = totalTaxableAmount.add(taxableIncome.multiply(this.rates.get(i)));
      netTaxableIncome = netTaxableIncome.subtract(taxableIncome);
    }
    return totalTaxableAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
  }

}