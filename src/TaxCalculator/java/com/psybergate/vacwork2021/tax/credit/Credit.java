package com.psybergate.vacwork2021.tax.credit;

public class Credit {
  private static double MAX_MEDICAL_CREDITS = 12000.00;

  private double medicalCredits;

  private double primaryRebate;

  public Credit(double medicalCredits, double primaryRebate) {
    this.medicalCredits = medicalCredits;
    this.primaryRebate = primaryRebate;

  }
  public Credit(){

  }

  public double totalCredits(double medicalCredits, double primaryRebate) {

    return getMedicalCredits(medicalCredits) + primaryRebate;
  }

  public double getMedicalCredits(double medicalCredits) {
    if (medicalCredits < MAX_MEDICAL_CREDITS) {
      return medicalCredits;
    } else {
      return MAX_MEDICAL_CREDITS;
    }
  }

  public double getMedicalCredits() {
    return medicalCredits;
  }

  public double getPrimaryRebate() {
    return primaryRebate;
  }

}
