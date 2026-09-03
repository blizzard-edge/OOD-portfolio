import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * Author: Caitlin Hagler
 * Class: Main
 * Purpose: Entry point for the Zoo Simulation.
 * Last Revision Date: September 2, 2026
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Main is intentionally kept simple.
        PrintStream output = new PrintStream("zoo_simulation.txt");
        
        System.setOut(output);
        
        // The Zoo object handles initialization and simulation logic.
        Zoo zoo = new Zoo();
        zoo.runSimulation();
        
        output.close();
    }
}