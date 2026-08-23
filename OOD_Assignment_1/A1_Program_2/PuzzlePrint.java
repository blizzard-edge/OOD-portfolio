import java.util.ArrayList;

public class PuzzlePrint {
  // Print the randomized tokens, with four tokens per line.
  public void printTokens(ArrayList<String> tokens) {
    System.out.println("Tokens");

    for (int i = 0; i < tokens.size(); i++) {
      System.out.print(tokens.get(i) + "\t");

        // Start a new line after every four tokens.
        if ((i + 1) % 4 == 0) {
          System.out.println();
        }
      }

      // Make sure the output ends with a new line
      // if the final row contains fewer than four tokens.
      if (tokens.size() % 4 != 0) {
        System.out.println();
      }
    }

  // Print the list of clues.
  public void printClues(ArrayList<String> clues) {
    System.out.println("Clues");

    for (String clue : clues) {
      System.out.println(clue);
      }
    }

  // Print the original words in uppercase as the answer key.
  public void printAnswerKey(ArrayList<String> words) {
    System.out.println("Answer Key");

    for (String word : words) {
      System.out.println(word);
    }
  }
}
