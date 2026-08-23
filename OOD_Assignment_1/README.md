# Assignment 1: Java OO Refresher Development
This introductory assignment is intended to be done by you as a solo effort. The goal of this assignment is to
prepare you to perform basic OO design and development tasks with Java, to familiarize you with basic Java if
you need the practice, and to ensure your Java development environments are set up appropriately.

----------------------------------------------------------------------------------------------------------------------

# Program 1: Compare the results of using three random number generators using Java arrays.

Enter a loop asking for an integer value, numRands, from the user in the console

    • When a user enters a null input (i.e. hits return with no number) the input loop (and the
    program) should end
  
Generate 3 arrays of double values between 0 and 1, with each array of length numRands, using the
following random functions from these Java libraries:

    • Java.util.Random
    
    • Math.random
    
    • java.util.concurrent.ThreadLocalRandom
  
At that point, apply these descriptive statistics methods against each array, including:

    • mean
    
    • standard deviation
    
    • minimum value
    
    • maximum value
  
Print out to the console a table of these values for the data from each library’s random function

    • Name of function, numRands, mean, std. dev., min, max
  
Return to the loop asking for user input until the program ends

There should be at least two classes: Creator, to create the random number arrays, and Analyzer, to
perform the statistics analysis on arrays passed to it

----------------------------------------------------------------------------------------------------------------------
# Program 2: Create a Java program that implements the following puzzle creator using Java ArrayLists.

Create a class called “Reader” with appropriate methods to:

    • Create an ArrayList of 7 words each of which must be at least five letters long and made up of
      only letters
  
    • Create an ArrayList of 7 clue strings corresponding to each of the 7 words above

Create a class called “Tokenizer” with appropriate methods to:

    • Break each word into 2 letter tokens (if the word has an odd length, the last token will be three
      letters long) and place them on an ArrayList
  
    • Create a single ArrayList of all tokens created
   
    • Randomize the order of all the tokens from all words in the ArrayList

Create a class called “PuzzlePrint” with appropriate methods to:

    • Print “Tokens”, followed by the randomized tokens printed out as a table, 4 tokens per line, tab
      delimited (the last line printed may have less than 4 tokens in it)
   
    • Print “Clues”, followed by a list of the entered clues
   
    • Print “Answer Key”, followed by the original words entered in uppercase
