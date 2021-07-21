package com.psybergate.vacwork2021.tax.testexpense;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExpense {

  private static Expense expenses;

  @BeforeAll
  public static void setup(){
    expenses = new Expense();
  }
  @Test
  @DisplayName("Total expenses: ")
  public void TestingTotalExpenses(){
    BigDecimal retirementFund = new BigDecimal(150000);
    BigDecimal travelAllowance = new BigDecimal(100000);
    BigDecimal expectedAmount = new BigDecimal(224375);
    assertEquals(expectedAmount, expenses.calculateTotalExpenses(retirementFund,travelAllowance));
  }
  @Test
  @DisplayName("Travel allowance:")
  public void TestingTravelAllowance(){
    BigDecimal travelAllowance = new BigDecimal(100000);
    BigDecimal expectedAmount = new BigDecimal(80000);
    assertEquals(expectedAmount, expenses.calculateTravelAllowance(travelAllowance));
  }
  @Test
  @DisplayName("Retirement fund:")
  public void TestingRetirementFund(){
    BigDecimal retirementFund = new BigDecimal(150000);
    BigDecimal expectedAmount = new BigDecimal(144375);
    assertEquals(expectedAmount, expenses.calculateRetirementFund(retirementFund));
  }

}
