package com.psybergate.vacwork2021.tax.taxcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {
  private static final BigDecimal salary = new BigDecimal("500000.00");

  private static final BigDecimal bonus = new BigDecimal("25000.00");

  private static final BigDecimal interestReceived = new BigDecimal("45000.00");

  private static final BigDecimal totalCapitalGains = new BigDecimal("800000.00");

  private static final BigDecimal retirementFund = new BigDecimal("150000.00");

  private static final BigDecimal travelAllowance = new BigDecimal("100000.00");

  private static final BigDecimal medicalCredits = new BigDecimal("15000.00");

  private static final BigDecimal primaryRebate = new BigDecimal("15714.00");

  private static final BigDecimal netTaxableIncome = new BigDecimal("625825.00");

  private static TaxCalculator taxCalculator;

  @BeforeAll
  public static void setup() {

    taxCalculator = new TaxCalculator();

  }

  @Test
  @DisplayName("Travel allowance: ")
  public void TestingTravelAllowance() {
    BigDecimal expectedAmount = new BigDecimal("80000.00");
    assertEquals(expectedAmount, taxCalculator.calculateTravelAllowance(travelAllowance));
  }

  @Test
  @DisplayName("Retirement Fund: ")
  public void testingRetirementFund() {

    BigDecimal expectedAmount = new BigDecimal("144375.00");
    assertEquals(expectedAmount, taxCalculator.calculateRetirementFund(retirementFund));
  }

  @Test
  @DisplayName("Total Expenses: ")
  public void testingTotalExpenses() {

    BigDecimal expectedAmount = new BigDecimal("224375.00");
    assertEquals(expectedAmount, taxCalculator.calculateTotalExpenses(retirementFund, travelAllowance));
  }

  @Test
  @DisplayName("Interest received: ")
  public void testingInterestReceived() {

    BigDecimal expectedAmount = new BigDecimal("21200.00");
    assertEquals(expectedAmount, taxCalculator.calculateInterestReceived(interestReceived));
  }

  @Test
  @DisplayName("Total capital gains: ")
  public void testingCapitalGains() {

    BigDecimal expectedAmount = new BigDecimal(304000);
    assertEquals(expectedAmount, taxCalculator.calculateCapitalGains(totalCapitalGains));
  }

  @Test
  @DisplayName("Total income: ")
  public void testingTotalIncome() {

    BigDecimal expectedAmount = new BigDecimal(850200);
    assertEquals(expectedAmount,
        taxCalculator.calculateTotalIncome(salary, bonus, interestReceived, totalCapitalGains));
  }

  @Test
  @DisplayName("Medical credits: ")
  public void testingMedicalCredits() {

    BigDecimal expectedAmount = new BigDecimal("12000.00");
    assertEquals(expectedAmount, taxCalculator.calculateMedicalCredits(medicalCredits));
  }

  @Test
  @DisplayName("Total credits: ")
  public void testingTotalCredits() {

    BigDecimal expectedAmount = new BigDecimal("27714.00");
    assertEquals(expectedAmount, taxCalculator.calculateTotalCredits(medicalCredits, primaryRebate));
  }

  @Test
  @DisplayName("Payable tax: ")
  public void testingPayableTax() {

    BigDecimal expectedAmount = new BigDecimal(168103);
    assertEquals(expectedAmount, taxCalculator.payableTax(netTaxableIncome));
  }

  @Test
  @DisplayName("Net payable tax: ")
  public void testingNetPayableTax() {

    BigDecimal expectedAmount = new BigDecimal(140389);
    assertEquals(expectedAmount, taxCalculator
        .netTaxPayableTax(taxCalculator.calculateTotalCredits(medicalCredits, primaryRebate),
            taxCalculator.payableTax(netTaxableIncome)));
  }

}
