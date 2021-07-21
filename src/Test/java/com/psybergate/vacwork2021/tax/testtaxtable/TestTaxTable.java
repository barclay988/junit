package com.psybergate.vacwork2021.tax.testtaxtable;

import com.psybergate.vacwork2021.tax.taxtable.TaxTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaxTable {
  private static TaxTable taxTable;

  @BeforeAll
  public static void setup(){
    taxTable = new TaxTable();
  }
  @Test
  @DisplayName("Payable tax: ")
  public void testingTaxTable(){
    assertEquals(168103,taxTable.payableTax(625825));
  }
}
