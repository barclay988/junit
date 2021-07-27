package com.psybergate.vacwork2021.tax.taxcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {



  private static TaxCalculator taxCalculator;

  @BeforeAll
  public static void setup() {

    taxCalculator = new TaxCalculator();

  }

  @Test
  @DisplayName("Travel allowance: ")
  public void TestingTravelAllowance() {
    BigDecimal expectedAmount = new BigDecimal("80000.00");
    assertEquals(expectedAmount, taxCalculator.calculateTravelAllowance(BigDecimal.valueOf(100000.00)));
  }

  @Test
  @DisplayName("Retirement Fund: ")
  public void testingRetirementFund() {

    BigDecimal expectedAmount = new BigDecimal("144375.00");
    assertEquals(expectedAmount, taxCalculator.calculateRetirementFund(BigDecimal.valueOf(150000.00)));
  }

  @Test
  @DisplayName("Total Expenses: ")
  public void testingTotalExpenses() {

    BigDecimal expectedAmount = new BigDecimal("224375.00");
    assertEquals(expectedAmount, taxCalculator.calculateTotalExpenses(BigDecimal.valueOf(150000.00),BigDecimal.valueOf(100000.00)));
  }

  @Test
  @DisplayName("Interest received: ")
  public void testingInterestReceived() {

    BigDecimal expectedAmount = new BigDecimal("21200.00");
    assertEquals(expectedAmount, taxCalculator.calculateInterestReceived(BigDecimal.valueOf(45000.00)));
  }

  @Test
  @DisplayName("Total capital gains: ")
  public void testingCapitalGains() {

    BigDecimal expectedAmount = new BigDecimal(304000);
    assertEquals(expectedAmount, taxCalculator.calculateCapitalGains(BigDecimal.valueOf(800000.00)));
  }

  @Test
  @DisplayName("Total income: ")
  public void testingTotalIncome() {

    BigDecimal expectedAmount = new BigDecimal(850200);
    assertEquals(expectedAmount,
        taxCalculator.calculateTotalIncome(BigDecimal.valueOf(500000.00), BigDecimal.valueOf(25000.00), BigDecimal.valueOf(45000.00), BigDecimal.valueOf(800000.00)));
  }

  @Test
  @DisplayName("Medical credits: ")
  public void testingMedicalCredits() {

    BigDecimal expectedAmount = new BigDecimal("12000.00");
    assertEquals(expectedAmount, taxCalculator.calculateMedicalCredits(BigDecimal.valueOf(15000.00)));
  }

  @Test
  @DisplayName("Total credits: ")
  public void testingTotalCredits() {

    BigDecimal expectedAmount = new BigDecimal("27714.00");
    assertEquals(expectedAmount, taxCalculator.calculateTotalCredits(BigDecimal.valueOf(15000.00), BigDecimal.valueOf(15714.00)));
  }

  @Test
  @DisplayName("Payable tax: ")
  public void testingPayableTax() {

    BigDecimal expectedAmount = new BigDecimal(168103);
    assertEquals(expectedAmount, taxCalculator.payableTax(BigDecimal.valueOf(625825.00)));
  }

  @Test
  @DisplayName("Net payable tax: ")
  public void testingNetPayableTax() {

    BigDecimal expectedAmount = new BigDecimal(140389);
    assertEquals(expectedAmount, taxCalculator.netTaxPayableTax(taxCalculator.calculateTotalCredits(BigDecimal.valueOf(15000.00),
        BigDecimal.valueOf(15714.00)), taxCalculator.payableTax(BigDecimal.valueOf(625825.00))));
  }

}
