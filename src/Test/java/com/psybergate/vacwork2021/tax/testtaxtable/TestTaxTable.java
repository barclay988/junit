package com.psybergate.vacwork2021.tax.testtaxtable;

import com.psybergate.vacwork2021.tax.taxtable.TaxTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaxTable {
  private static TaxTable taxTable;

  @BeforeAll
  public static void setup(){
    taxTable = new TaxTable();
    taxTable.setLowerBounds();
    taxTable.setUpperBounds();
    taxTable.setRates();
  }
  @Test
  @DisplayName("Payable tax: ")
  public void testingTaxTable(){
    BigDecimal netTaxableIncome = new BigDecimal(625825.00);
    BigDecimal expectedAmount = new BigDecimal(168103);
    assertEquals(expectedAmount,taxTable.payableTax(netTaxableIncome));
  }
}
