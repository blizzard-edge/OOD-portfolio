import java.util.ArrayList;

public class Reader {
  private static final String[] WORDS = {
    "printer",
    "keyboard",
    "monitor",
    "computer",
    "program",
    "internet",
    "software"
  };

  private static final String[] CLUES = {
    "Device made to waste ink and paper",
    "Input device with many keys",
    "Screen used to display information",
    "Electronic machine that processes data",
    "Instructions that tell a computer what to do",
    "Global network connecting computers",
    "Programs used by a computer"
  };

public ArrayList<String> createWords() {
    ArrayList<String> words = new ArrayList<>();

    for (String word : WORDS) {
      words.add(word.toUpperCase());
    }
    return words;
  }

  public ArrayList<String> createClues() {
    ArrayList<String> clues = new ArrayList<>();

    for (String clue : CLUES) {
      clues.add(clue);
    }
    return clues;
  }
}
