import java.util.Random;

public class Jar {
  private final String itemName;
  private final int amount;
  private int actualAmount;
  
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
  
  public void fill() {
    Random random = new Random();
    actualAmount = random.nextInt(getAmount() + 1);
  }
  
  public int getActualAmount() {
    return actualAmount;
  }

}