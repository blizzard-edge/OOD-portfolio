//Analyzer.java
public class Analyzer {
	private double[] values;

	// Store the array that will be analyzed.
	public Analyzer(double[] values) {
		this.values = values;
	}

	// Find the smallest value in the array.
	public double findMinimum() {
		// Start by assuming the first value is the minimum.
		double minimum = values[0];

		// Compare each remaining value to the current minimum.
		for (int i = 1; i < values.length; i++) {
			if (values[i] < minimum) {
				minimum = values[i];
			}
		}
		return minimum;
	}

	// Find the largest value in the array.
	public double findMaximum() {
		// Start by assuming the first value is the maximum.
		double maximum = values[0];

		// Compare each remaining value to the current maximum.
		for (int i = 1; i < values.length; i++) {
			if (values[i] > maximum) {
				maximum = values[i];
			}
		}
		return maximum;
	}

	// Calculate the arithmetic mean of the array.
	public double calculateMean() {
		double sum = 0;

		// Add all values together.
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		// Divide the sum by the number of values.
		return sum / values.length;
	}

	// Calculate the population standard deviation of the array.
	public double calculateStandardDeviation() {
		// The standard deviation calculation requires the mean first.
		double mean = calculateMean();
		double sum = 0;

		// Calculate the squared difference between each value and the mean.
		for (int i = 0; i < values.length; i++) {
			double difference = values[i] - mean;
			sum += difference * difference;
		}

		// Calculate the variance.
		double variance = sum / values.length;

		// Calculate the square root of the variance manually.
		return calculateSquareRoot(variance);
	}

	// Calculate a square root using Newton's method.
	private double calculateSquareRoot(double value) {
		if (value == 0) {
			return 0;
		}

		double guess = value;

		// Repeatedly improve the square-root approximation.
		for (int i = 0; i < 20; i++) {
			guess = (guess + value / guess) / 2;
		}
		return guess;
	}
}
