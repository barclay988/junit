package com.psybergate.vacwork2021.tax.testtaxcalculator;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.credit.Credit;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxcalculator.TaxCalculator;
import com.psybergate.vacwork2021.tax.taxtable.TaxTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaxCalculator {
  private static Income income;
  private  static Expense expense;
  private static Credit credit;
  private static TaxCalculator taxCalculator;
  private static TaxTable taxTable;

  @BeforeAll
  public static void setup(){
    income = new Income(500000,25000,45000,800000);
    expense = new Expense(150000,100000);
    credit = new Credit(15000,15174);
    taxTable = new TaxTable();
    taxCalculator = new TaxCalculator(income,expense,credit,taxTable);
  }
  @Test
  @DisplayName("Total payable tax: ")
  public void TestingTaxCalculator(){
    assertEquals(140389,taxCalculator.netTaxPayableTax(income,expense,credit,taxTable));
  }

}
