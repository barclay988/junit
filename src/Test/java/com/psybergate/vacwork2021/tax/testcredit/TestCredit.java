package com.psybergate.vacwork2021.tax.testcredit;

import com.psybergate.vacwork2021.tax.credit.Credit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCredit {

  private static Credit credits;

  @BeforeAll
  public static void setup(){
    credits = new Credit();
  }
  @Test
  @DisplayName("Total credits: ")
  public void TestingTotalCredits(){
    assertEquals(27714, credits.totalCredits(15000,15714));
  }

  @Test
  @DisplayName("Medical credits: ")
  public void TestingMedicalCredits(){
    assertEquals(12000, credits.getMedicalCredits(15000));
  }


}
