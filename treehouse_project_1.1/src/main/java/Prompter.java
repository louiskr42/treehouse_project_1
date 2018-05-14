import java.util.Scanner;

public class Prompter {
  
  private Scanner scanner;
  Jar jar;

  public Prompter() {
    
  }
  
  public void setUpGame() {
    scanner = new Scanner(System.in);
    System.out.printf("SETUP FOR THE ADMINISTRATOR%n" +
                      "---------------------------%n");
    String itemName = promptForItemName();
    int amount = promptForAmount(itemName);
    
    jar = new Jar(itemName, amount);
    jar.fill();
  }
  
  public String getItemName() {
    return jar.getItemName();
  }
  
  public int getAmount() {
    return jar.getAmount();
  }
  
  public int getActualAmount() {
    return jar.getActualAmount();
  }
  
  
  private String promptForItemName() {
    String name;
    do {
    System.out.println("What type of item?");
    name = scanner.nextLine();
    } while(!isNameAcceptable(name));
    
    return name;
  }
  
  private boolean isNameAcceptable(String name) {
    boolean isAcceptable = false;
    
    if (name.isEmpty() || name.replace(" ", "").isEmpty()) {
      System.out.println("Sorry, but you have to fill the jar with something!");
    } else {
      isAcceptable = true;
    }
    
    return isAcceptable;
  }
  
  private boolean isAmountAcceptable(int amount) {
    boolean isAcceptable = false;
    
    if (amount <= 0) {
      System.out.println("You have to pick 1 or higher!");
    } else {
      isAcceptable = true;
    }
    
    return isAcceptable;
  }
  
  private int promptForAmount(String itemName) {
    int sizeOfJar = 0;
    do {
      System.out.printf("How many %s can fit into your jar?%n", itemName);
      try {
        sizeOfJar = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println("Sorry, but only numbers allowed!");
      }
    } while(!isAmountAcceptable(sizeOfJar));
    
    return sizeOfJar;
  }
  
  public boolean isWon(int guess) {
    boolean guessIsRight = false;
    int actualAmount = jar.getActualAmount();
    if (guess == actualAmount) {
      guessIsRight = true;
    } else if (guess > actualAmount) {
      System.out.println("Your guess is too high.");
    } else {
      System.out.println("Your guess is too low.");
    }
    
    return guessIsRight;
  }
  
  
  public int promptForGuess() {
    Scanner scanner2 = new Scanner(System.in);
    System.out.println("What's your guess?");
    int guess = 0;
    do {
      try {
          guess = Integer.parseInt(scanner2.nextLine());
      } catch (NumberFormatException nfe) {
          System.out.println("Sorry, but only numbers allowed!");
      }
    } while (!isGuessAcceptable(guess));
    
    return guess;
  }
  
  private boolean isGuessAcceptable(int guess) {
    boolean isAcceptable = false;
    
    if (guess <= 0) {
      System.out.println("You have to pick 1 or higher!");
    } else if (guess > getAmount()) {
      System.out.printf("Your guess must be %d or lower!%n", getAmount());
    } else {
      isAcceptable = true;
    }
    
    return isAcceptable;
  }
}