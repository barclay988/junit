package com.psybergate.vacwork2021.tax.testcredit;

import com.psybergate.vacwork2021.tax.credit.Credit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCredit {
  private final BigDecimal medicalCredits = new BigDecimal(15000);
  private final BigDecimal primaryRebate = new BigDecimal(15714);

  private static Credit credits;

  @BeforeAll
  public static void setup(){
    credits = new Credit();
  }
  @Test
  @DisplayName("Total credits: ")
  public void TestingTotalCredits(){

    BigDecimal expectedAmount = new BigDecimal(27714.00);
    assertEquals(expectedAmount, credits.totalCredits(medicalCredits,primaryRebate));
  }

  @Test
  @DisplayName("Medical credits: ")
  public void TestingMedicalCredits(){
    BigDecimal expectedAmount = new BigDecimal(12000);
    assertEquals(expectedAmount, credits.getMedicalCredits(medicalCredits));
  }



}
