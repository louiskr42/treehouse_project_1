import java.util.Random;

public class GuessingGame {
  
  Jar jar;
    
  public static void main(String[] args) {
    Prompter prompter = new Prompter();
    prompter.setUpGame();
    
    System.out.printf("%nPLAYER%n" +
               "-------------------%n" +
               "Your goal is to guess how many %s are in the jar. Your guess should be between 1 and %d. So let's get started!%n",
                      prompter.getItemName(), prompter.getAmount());
    int guess;
    Random random = new Random();
    int actualAmount = random.nextInt(prompter.getAmount() + 1);
    if (actualAmount == 0){actualAmount = 1;}
    int amountOfGuesses = 0;
    do {
      guess = prompter.promptForGuess();
      amountOfGuesses++;
    } while(!prompter.isWon(guess, actualAmount));
    
    System.out.printf("Congratulations! You guessed that there are %d %s in the jar!%nIt took you %d guess(es).%n",
                      actualAmount, prompter.getItemName(), amountOfGuesses);
  }
  
}
