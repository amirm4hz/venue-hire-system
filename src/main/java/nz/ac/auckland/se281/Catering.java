package nz.ac.auckland.se281;

public class Catering extends Services {

  private String cateringType;
  private int cateringCost;

  public Catering(String referenceNumber, String cateringType, int cateringCost) {
    super(referenceNumber);
    this.cateringType = cateringType;
    this.cateringCost = cateringCost;
  }

  public String getCateringType() {
    return cateringType;
  }

  public int getCateringCost() {
    return cateringCost;
  }
}
