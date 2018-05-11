public class Jar {
  private final String itemName;
  private final int amount;

  public Jar(String itemName, int amount) {
    this.itemName = itemName;
    this.amount = amount;
  }
  
  public int getAmount() {
    return amount;
  }
  
  public String getItemName() {
    return itemName;
  }

}