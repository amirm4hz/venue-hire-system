package nz.ac.auckland.se281;

public class Music extends Services {

  private String musicType;
  private int musicCost;

  public Music(String referenceNumber, String musicType, int musicCost) {
    super(referenceNumber);
    this.musicType = musicType;
    this.musicCost = musicCost;
  }

  public String getMusicType() {
    return musicType;
  }

  public int getMusicCost() {
    return musicCost;
  }
}
