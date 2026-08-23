import java.util.ArrayList;

/* 
*  Project title: Assignment 1: Program 2
*  Author: Caitlin Hagler
*  Class CPSC 6119 Object-Oriented Development Section 01
*  Last updated on: 08/18/26
*  IDE: BlueJ
*/

/* 1. Program 2 - Puzzle Creator
*  Main class: 
*    Coordinates the creation and printing of the puzzle.
*  Reader class: 
*    Stores the seven words and clues and creates the required ArrayLists.
*  Tokenizer class: 
*    Breaks the words into tokens, combines the tokens, and randomizes their order.
*  PuzzlePrint class: 
*    Displays the randomized tokens, clues, and answer key.
*
*  Program 2 creates a word puzzle using Java ArrayLists.
*
*  The program starts with seven words and seven corresponding clues. 
*  The words are converted to uppercase and divided into two-letter tokens. 
*  If a word has an odd number of letters, the final token contains three letters.
*
*  All tokens from the seven words are combined into a single ArrayList and randomized before being displayed.
*/

public class Main {
  public static void main(String[] args) {

    // Create the objects needed for the puzzle.
    Reader reader = new Reader();
    Tokenizer tokenizer = new Tokenizer();
    PuzzlePrint printer = new PuzzlePrint();

    // Get the words and clues from Reader.
    ArrayList<String> words = reader.createWords();
    ArrayList<String> clues = reader.createClues();

    // Create the combined list of tokens from all words.
    ArrayList<String> tokens = tokenizer.createAllTokens(words);

    // Randomize the order of the tokens.
    tokenizer.randomizeTokens(tokens);

    // Print the puzzle.
    printer.printTokens(tokens);
    System.out.println();

    printer.printClues(clues);
    System.out.println();

    printer.printAnswerKey(words);
  }
}
