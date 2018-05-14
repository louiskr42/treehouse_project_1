

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
    int amountOfGuesses = 0;
    do {
      guess = prompter.promptForGuess();
      amountOfGuesses++;
    } while(!prompter.isWon(guess));
    
    System.out.printf("Congratulations! You guessed that there are %d %s in the jar!%nIt took you %d guess(es).%n",
                      prompter.getActualAmount(), prompter.getItemName(), amountOfGuesses);
  }
  
}
