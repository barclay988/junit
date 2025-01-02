import java.math.BigDecimal;
public class Credit {
  private static final BigDecimal MAX_MEDICAL_CREDITS = new BigDecimal(12000.00);

  private BigDecimal medicalCredits;

  private BigDecimal primaryRebate;

  public Credit(BigDecimal medicalCredits, BigDecimal primaryRebate) {
    this.medicalCredits = medicalCredits;
    this.primaryRebate = primaryRebate;

  }
  public Credit(){

  }

  public BigDecimal totalCredits(BigDecimal medicalCredits, BigDecimal primaryRebate) {

    return getMedicalCredits(medicalCredits).add(primaryRebate) ;
  }

  public BigDecimal getMedicalCredits(BigDecimal medicalCredits) {
    if (medicalCredits.compareTo(MAX_MEDICAL_CREDITS) < 0) {
      return medicalCredits;
    } else {
      return MAX_MEDICAL_CREDITS;
    }
  }

  public BigDecimal getMedicalCredits() {
    return medicalCredits;
  }

  public BigDecimal getPrimaryRebate() {
    return primaryRebate;
  }

}
