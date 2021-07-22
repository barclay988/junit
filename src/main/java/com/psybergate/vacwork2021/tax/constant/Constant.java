package com.psybergate.vacwork2021.tax.constant;

import java.math.BigDecimal;

public interface Constant {

  BigDecimal INTEREST_EXEMPTION_AMOUNT = new BigDecimal(23800.00);

  BigDecimal CAPITAL_GAINS_RATE = new BigDecimal(0.4);

  BigDecimal CAPITAL_GAINS_EXEMPTION_AMOUNT = new BigDecimal(40000.00);


  BigDecimal RETIREMENT_FUND_EXEMPTION = new BigDecimal(144375.00) ;

  BigDecimal TRAVEL_ALLOWANCE_EXEMPTION = new BigDecimal(80000.00);


  BigDecimal MAX_MEDICAL_CREDITS = new BigDecimal(12000.00);
}
