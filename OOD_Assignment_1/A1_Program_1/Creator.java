import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Creator.java
public class Creator {
	// Creates an array using java.util.Random.
	public double[] createRandomArray(int numRands) {
		Random random = new Random();

		double[] values = new double[numRands];

		// Fill the array with random values between 0 and 1.
		for (int i = 0; i < numRands; i++) {
			values[i] = random.nextDouble();
		}
		return values;
	}

// Creates an array using Math.random().
	public double[] createMathArray(int numRands) {
		double[] values = new double[numRands];

		// Fill the array with random values between 0 and 1.
		for (int i = 0; i < numRands; i++) {
			values[i] = Math.random();
		}
		return values;
	}

	// Creates an array using ThreadLocalRandom.
	public double[] createThreadLocalArray(int numRands) {
		double[] values = new double[numRands];

		// Fill the array with random values between 0 and 1.
		for (int i = 0; i < numRands; i++) {
			values[i] = ThreadLocalRandom.current().nextDouble();
		}
		return values;
	}
}
