# Program 2 - Puzzle Creator
Main class: 
  Coordinates the creation and printing of the puzzle.
  
Reader class:
  Stores the seven words and clues and creates the required ArrayLists.
  
Tokenizer class:
  Breaks the words into tokens, combines the tokens, and randomizes their order.
  
PuzzlePrint class:
  Displays the randomized tokens, clues, and answer key.

----------------------------------------------------------------------------------------------------------------------
Program 2 creates a word puzzle using Java ArrayLists.

The program starts with seven words and seven corresponding clues. 
The words are converted to uppercase and divided into two-letter tokens. 
If a word has an odd number of letters, the final token contains three letters.

All tokens from the seven words are combined into a single ArrayList and randomized before being displayed.
