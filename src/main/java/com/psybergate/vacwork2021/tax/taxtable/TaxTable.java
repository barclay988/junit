package com.psybergate.vacwork2021.tax.taxtable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxTable {

  private final ArrayList<BigDecimal> lowerBounds = new ArrayList<BigDecimal>(7);

  private final BigDecimal firstLowerBound = new BigDecimal("0.00");

  private final BigDecimal secondLowerBound = new BigDecimal("216200.00");

  private final BigDecimal thirdLowerBound = new BigDecimal("337801.00");

  private final BigDecimal fourthLowerBound = new BigDecimal("467501.00");

  private final BigDecimal fiveLowerBound = new BigDecimal("613601.00");

  private final BigDecimal sixthLowerBound = new BigDecimal("782201.00");

  private final BigDecimal seventhLowerBound = new BigDecimal("1656601.00");

  private final ArrayList<BigDecimal> upperBounds = new ArrayList<BigDecimal>(7);

  private final BigDecimal firstUpperBound = new BigDecimal("216200.00");

  private final BigDecimal secondUpperBound = new BigDecimal("337800.00");

  private final BigDecimal thirdUpperBound = new BigDecimal("467500.00");

  private final BigDecimal fourthUpperBound = new BigDecimal("613600.00");

  private final BigDecimal fiveUpperBound = new BigDecimal("782200.00");

  private final BigDecimal sixthUpperBound = new BigDecimal("1656600.00");

  private final BigDecimal seventhUpperBound = new BigDecimal("100000000.00");

  private final ArrayList<BigDecimal> rates = new ArrayList<BigDecimal>(7);

  private final BigDecimal firstRate = new BigDecimal("0.18");

  private final BigDecimal secondRate = new BigDecimal("0.26");

  private final BigDecimal thirdRate = new BigDecimal("0.31");

  private final BigDecimal fourthRate = new BigDecimal("0.36");

  private final BigDecimal fiveRate = new BigDecimal("0.39");

  private final BigDecimal sixthRate = new BigDecimal("0.41");

  private final BigDecimal seventhRate = new BigDecimal("0.45");


  public TaxTable() {

  }

  public void initializeLowerBounds() {
    lowerBounds.add(firstLowerBound);
    lowerBounds.add(secondLowerBound);
    lowerBounds.add(thirdLowerBound);
    lowerBounds.add(fourthLowerBound);
    lowerBounds.add(fiveLowerBound);
    lowerBounds.add(sixthLowerBound);
    lowerBounds.add(seventhLowerBound);
  }

  public void initializeUpperBounds() {
    upperBounds.add(firstUpperBound);
    upperBounds.add(secondUpperBound);
    upperBounds.add(thirdUpperBound);
    upperBounds.add(fourthUpperBound);
    upperBounds.add(fiveUpperBound);
    upperBounds.add(sixthUpperBound);
    upperBounds.add(seventhUpperBound);
  }


  public void initializeRates() {
    rates.add(firstRate);
    rates.add(secondRate);
    rates.add(thirdRate);
    rates.add(fourthRate);
    rates.add(fiveRate);
    rates.add(sixthRate);
    rates.add(seventhRate);
  }
  public ArrayList<BigDecimal> getLowerBounds(){
    return lowerBounds;
  }
  public ArrayList<BigDecimal> getUpperBounds(){
    return upperBounds;
  }
  public ArrayList<BigDecimal> getRates(){
    return rates;
  }



}