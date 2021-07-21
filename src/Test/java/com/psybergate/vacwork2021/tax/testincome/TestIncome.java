package com.psybergate.vacwork2021.tax.testincome;

import com.psybergate.vacwork2021.tax.income.Income;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIncome {
  private static final BigDecimal salary = new BigDecimal(500000);
  private static final BigDecimal bonus = new BigDecimal(25000);
  private static final BigDecimal interestReceived = new BigDecimal(45000);
  private static final BigDecimal totalCapitalGains = new BigDecimal(800000);
  private static Income income;

  @BeforeAll
  public static void setup(){
    income = new Income();
  }

  @Test
  @DisplayName("Interest received: ")
  public void TestingInterestReceived(){
   // BigDecimal interestReceived = new BigDecimal(45000);
    BigDecimal expectedAmount = new BigDecimal(21200);
    assertEquals(expectedAmount, Income.calculateInterestReceived(interestReceived));
  }

  @Test
  @DisplayName("Total capital gains: ")
  public void TestingCapitalGains(){
    //BigDecimal totalCapitalGains = new BigDecimal(800000);
    BigDecimal expectedAmount = new BigDecimal(304000);
    assertEquals(expectedAmount, Income.calculateCapitalGains(totalCapitalGains));
  }

  @Test
  @DisplayName("Total income: ")
  public void TestingTotalIncome(){

    BigDecimal expectedAmount = new BigDecimal(850200);
    assertEquals(expectedAmount, Income.calculateTotalIncome(salary,bonus,interestReceived,totalCapitalGains));
  }

}
