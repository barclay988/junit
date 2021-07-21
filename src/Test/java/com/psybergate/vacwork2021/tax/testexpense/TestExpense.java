package com.psybergate.vacwork2021.tax.testexpense;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    assertEquals(224375, expenses.calculateTotalExpenses(150000,100000));
  }
  @Test
  @DisplayName("Travel allowance:")
  public void TestingTravelAllowance(){
    assertEquals(80000, expenses.calculateTravelAllowance(100000));
  }
  @Test
  @DisplayName("Retirement fund:")
  public void TestingRetirementFund(){
    assertEquals(144375, expenses.calculateRetirementFund(150000));
  }

}
