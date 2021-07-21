package com.psybergate.vacwork2021.tax.testtaxcalculator;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.credit.Credit;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxcalculator.TaxCalculator;
import com.psybergate.vacwork2021.tax.taxtable.TaxTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaxCalculator {
  private static final BigDecimal salary = new BigDecimal(500000);
  private static final BigDecimal bonus = new BigDecimal(25000);
  private static final BigDecimal interestReceived = new BigDecimal(45000);
  private static final BigDecimal totalCapitalGains = new BigDecimal(800000);

  private static final BigDecimal retirementFund = new BigDecimal(150000);
  private static final BigDecimal travelAllowance = new BigDecimal(100000);

  private static final BigDecimal medicalCredits = new BigDecimal(15000);
  private static final BigDecimal primaryRebate = new BigDecimal(15714);
  private static final BigDecimal netTaxableIncome = new BigDecimal(625825.00);

  private static Income income;
  private  static Expense expense;
  private static Credit credit;
  private static TaxCalculator taxCalculator;
  private static TaxTable taxTable;



  @BeforeAll
  public static void setup(){

    income = new Income(salary,bonus,interestReceived,totalCapitalGains);
    expense = new Expense(retirementFund,travelAllowance);
    credit = new Credit(medicalCredits,primaryRebate);
    taxTable = new TaxTable();
    taxTable.initializeLowerBounds();
    taxTable.initializeUpperBounds();
    taxTable.initializeRates();
    taxCalculator = new TaxCalculator(income,expense,credit,taxTable);
  }
  @Test
  @DisplayName("Total payable tax: ")
  public void TestingTaxCalculator(){
    BigDecimal expectedAmount = new BigDecimal(140389);
    assertEquals(expectedAmount,taxCalculator.netTaxPayableTax(income,expense,credit,taxTable));
  }
  @Test
  @DisplayName("Payable tax: ")
  public void testingTaxTable(){

    BigDecimal expectedAmount = new BigDecimal(168103);
    assertEquals(expectedAmount,TaxCalculator.payableTax(netTaxableIncome));
  }

}
