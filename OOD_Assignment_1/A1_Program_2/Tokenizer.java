import java.util.ArrayList;
import java.util.Collections;

public class Tokenizer {
  // Break one word into 2-letter tokens.
  // If three letters remain, they are placed in the final token.
    public ArrayList<String> tokenizeWord(String word) {
        ArrayList<String> tokens = new ArrayList<>();
    
        int i = 0;
    
        while (i < word.length()) {
            // If three letters remain, make them one token.
            if (word.length() - i == 3) {
                tokens.add(word.substring(i, i + 3));
                i += 3;
            }
            // Otherwise, take the next two letters.
            else {
                tokens.add(word.substring(i, i + 2));
                i += 2;
            }
        }
        return tokens;
    }

  // Create a single ArrayList containing the tokens
  // from all of the words.
  public ArrayList<String> createAllTokens(ArrayList<String> words) {
    ArrayList<String> allTokens = new ArrayList<>();

    for (String word : words) {
      allTokens.addAll(tokenizeWord(word));
    }
    return allTokens;
  }

  // Randomize the order of all tokens.
  public void randomizeTokens(ArrayList<String> tokens) {
    Collections.shuffle(tokens);
  }
}
