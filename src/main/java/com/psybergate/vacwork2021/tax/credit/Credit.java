package com.psybergate.vacwork2021.tax.credit;
import java.math.BigDecimal;
public class Credit {



  private BigDecimal medicalCredits;

  private BigDecimal primaryRebate;


  public Credit(){

  }
  public void setMedicalCredits(BigDecimal medicalCredits) {
    this.medicalCredits = medicalCredits;
  }

  public void setPrimaryRebate(BigDecimal primaryRebate) {
    this.primaryRebate = primaryRebate;
  }


  public BigDecimal getMedicalCredits() {
    return medicalCredits;
  }

  public BigDecimal getPrimaryRebate() {
    return primaryRebate;
  }

}
