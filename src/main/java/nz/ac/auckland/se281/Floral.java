package nz.ac.auckland.se281;

public class Floral extends Services {

  private String floralType;
  private int floralCost;

  public Floral(String referenceNumber, String floralType, int floralCost) {
    super(referenceNumber);
    this.floralType = floralType;
    this.floralCost = floralCost;
  }

  public String getFloralType() {
    return floralType;
  }

  public int getFloralCost() {
    return floralCost;
  }
}
