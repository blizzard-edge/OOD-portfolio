import java.util.Scanner;

/*	
*	Project title: Assignment 1: Program 1
*	Author: Caitlin Hagler
*	Class CPSC 6119 Object-Oriented Development Section 01
*	Last updated on: 08/18/26
*	IDE: BlueJ
*/

/* 1. Program 1 - Random Number Statistics
*	Creator class:
*		Creates arrays of random numbers using three different
*		Java random-number generators.
*
*	Analyzer class:
*		Calculates the mean, standard deviation, minimum,
*		and maximum values of an array.
*
*	Main class:
*		Gets the number of random values from the user,
*		creates and analyzes the arrays, and displays
*		the results in a table
*
*	Three random-number generators
*	Mean, standard deviation, minimum, and maximum calculated manually
*	Console output for at least three runs such as 10, 100, and 1000 values.
*/

//Main.java
public class Main {
	public static void main(String[] args) {
		// Create a Scanner to read input from the console.
		Scanner scanner = new Scanner(System.in);

		// Create a Creator object to generate the random arrays.
		Creator creator = new Creator();

		// Continue asking the user for input until they enter a blank line.
		while (true) {
			System.out.print("Enter numRands (or press Enter to quit): ");

			String input = scanner.nextLine();

			// An empty input ends the program.
			if (input.isEmpty()) {
				break;
			}

			// Convert the user's input from a String to an integer.
			int numRands;

			try {
                numRands = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number, such as 10, 100, or 1000.");
                continue;
            }

			// Make sure the number of random values is positive.
			if (numRands <= 0) {
                System.out.println("Please enter a positive whole number.");
                continue;
            }
			
			// Create an array using each of the three random-number generators.
			double[] randomValues = creator.createRandomArray(numRands);
			double[] mathValues = creator.createMathArray(numRands);
			double[] threadLocalValues = creator.createThreadLocalArray(numRands);

			// Create an Analyzer for each generated array.
			Analyzer randomAnalyzer = new Analyzer(randomValues);
			Analyzer mathAnalyzer = new Analyzer(mathValues);
			Analyzer threadLocalAnalyzer = new Analyzer(threadLocalValues);

			// Print the headings for the statistics table.
			System.out.printf("%-30s %-10s %-12s %-12s %-12s %-12s%n",
				"Function", "numRands", "Mean", "Std. Dev.", "Min", "Max");

			// Print the statistics for the java.util.Random array.
			System.out.printf("%-30s %-10d %-12.6f %-12.6f %-12.6f %-12.6f%n",
				"Random.nextDouble()",
				numRands,
				randomAnalyzer.calculateMean(),
				randomAnalyzer.calculateStandardDeviation(),
				randomAnalyzer.findMinimum(),
				randomAnalyzer.findMaximum());

			// Print the statistics for the Math.random array.
			System.out.printf("%-30s %-10d %-12.6f %-12.6f %-12.6f %-12.6f%n",
				"Math.random()",
				numRands,
				mathAnalyzer.calculateMean(),
				mathAnalyzer.calculateStandardDeviation(),
				mathAnalyzer.findMinimum(),
				mathAnalyzer.findMaximum());

			// Print the statistics for the ThreadLocalRandom array.
			System.out.printf("%-30s %-10d %-12.6f %-12.6f %-12.6f %-12.6f%n",
				"ThreadLocalRandom.nextDouble()",
				numRands,
				threadLocalAnalyzer.calculateMean(),
				threadLocalAnalyzer.calculateStandardDeviation(),
				threadLocalAnalyzer.findMinimum(),
				threadLocalAnalyzer.findMaximum());
		}
		// Close the Scanner when the program ends.
		scanner.close();
	}
}
