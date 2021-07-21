package com.psybergate.vacwork2021.tax.taxtable;

public class TaxTable {

  private final double[] lowerBound = {0, 216201, 337801, 467501, 613601, 782201, 1656601};

  private final double[] upperBound = {216200, 337800, 467500, 613600, 782200, 1656600, 1000000000};

  private final double[] rate = {0.18, 0.26, 0.31, 0.36, 0.39, 0.41, 0.45};
  public TaxTable() {
  }

  public double payableTax(double netTaxableIncome) {//break into smaller pieces
    double taxableIncomeAmount = 0.0;
    double totalTaxPayable = 0.0;
    for (int i = 0; i < lowerBound.length; i++) {
      taxableIncomeAmount = Math.min(netTaxableIncome, (this.upperBound[i] - this.lowerBound[i]));
      totalTaxPayable += taxableIncomeAmount * this.rate[i];
      netTaxableIncome -= taxableIncomeAmount;
    }
    return totalTaxPayable;
  }

}
