package com.psybergate.vacwork2021.tax.constant;

import java.math.BigDecimal;

public interface Constant {

  BigDecimal INTEREST_EXEMPTION_AMOUNT = new BigDecimal("23800.00");

  BigDecimal CAPITAL_GAINS_RATE = new BigDecimal("0.4");

  BigDecimal CAPITAL_GAINS_EXEMPTION_AMOUNT = new BigDecimal("40000.00");

  BigDecimal RETIREMENT_FUND_EXEMPTION = new BigDecimal("144375.00");

  BigDecimal TRAVEL_ALLOWANCE_EXEMPTION = new BigDecimal("80000.00");

  BigDecimal MAX_MEDICAL_CREDITS = new BigDecimal("12000.00");

  BigDecimal[] TAX_UPPER_BOUND = {new BigDecimal("216200.00"), new BigDecimal("337800.00"), new BigDecimal("467500.00")
      , new BigDecimal("613600.00"), new BigDecimal("782200.00"), new BigDecimal("1656600.00"), new BigDecimal(
      "1000000000.00")};

  BigDecimal[] TAX_LOWER_BOUND = {new BigDecimal("0.00"), new BigDecimal("216201.00"), new BigDecimal("337801.00")
      , new BigDecimal("467501.00"), new BigDecimal("613601.00"), new BigDecimal("782201.00"),
      new BigDecimal("1656601.00")};

  BigDecimal[] TAX_RATES = {new BigDecimal("0.18"), new BigDecimal("0.26"), new BigDecimal("0.31")
      , new BigDecimal("0.36"), new BigDecimal("0.39"), new BigDecimal("0.41"), new BigDecimal("0.45")};

}
