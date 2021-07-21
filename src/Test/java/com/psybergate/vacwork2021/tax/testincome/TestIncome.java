package com.psybergate.vacwork2021.tax.testincome;

import com.psybergate.vacwork2021.tax.income.Income;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIncome {
  private static Income income;

  @BeforeAll
  public static void setup(){
    income = new Income();
  }

  @Test
  @DisplayName("Interest received: ")
  public void TestingInterestReceived(){
    assertEquals(21200,income.calculateInterestReceived(45000));
  }

  @Test
  @DisplayName("Total capital gains: ")
  public void TestingCapitalGains(){
    assertEquals(304000,income.calculateCapitalGains(800000));
  }

  @Test
  @DisplayName("Total income: ")
  public void TestingTotalIncome(){
    assertEquals(850200,income.calculateTotalIncome(500000,25000,45000,800000));
  }

}
