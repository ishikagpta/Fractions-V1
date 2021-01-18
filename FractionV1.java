
/**
 * 
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Fraction V1
 * @date 10/7/20
 */
import java.util.Scanner;
import java.io.File;

/**
 * @version 1.0 This FractionV1 class takes in fraction input and prints out
 *          unique fractions with a counter of how many times the fraction value
 *          occurred in the file and deals with the exception case of dividing
 *          by 0.
 *
 */

public class FractionV1 {

	/**
	 * In this main method, I take the string input of each line of fraction from
	 * the fraction file and store each unique fraction in the fractions array and
	 * counter of how many times each unique fraction was repeated in the file in
	 * the counter array and finally output each unique fraction with its counter.
	 * In the case of dividing by 0, I print out an exception statement.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] fractions = new String[0];

		int[] counter = new int[0];

		// I used this try catch statement to read through a valid fractions.txt file
		// full of fractions. I catch the file and print an exception if it is not a
		// fractions.txt file
		try {
			File file = new File("fractions2.txt");
			Scanner readfile = new Scanner(file);

			// I use this while statement to continue to perform actions on each line of
			// fractions in the fraction file
			while (readfile.hasNextLine()) {
				String line = readfile.nextLine();

				// I split the fraction and separate the numerator and denominator
				String[] Split = line.split("/");
				int numerator1 = Integer.parseInt(Split[0]);
				int denominator1 = Integer.parseInt(Split[1]);

				// I use this boolean to inform whether or not I need to insert a value into the
				// fractions or counter arrays
				boolean insert = true;

				// First, I use the if statement to see if the denominator of the current
				// fraction string I am on in the file has a denominator of 0. If it does, I go
				// down to the if statement where boolean insert is set to true. If not, I go
				// into
				// the for loop to loop through all the unique fraction strings in the
				// fractions array and see if the current fraction string I am on in the file
				// matches
				// any fraction string in the fractions array using cross multiplication. If it
				// does, I go to the
				// corresponding
				// index in the counter array and up the count of the fraction count by 1 and
				// set boolean insert to false. If the fraction in the array that I am currently
				// on in the array that I am comparing to the current fraction string in the
				// file has a denominator 0, I skip the fraction and continue to the next
				// fraction in the array to cross multiply.
				if (denominator1 != 0) {

					for (int i = 0; i < fractions.length; i++) {

						if (counter[i] == -1) {
							continue;
						}
						String x = fractions[i];
						String[] split = x.split("/");
						int numerator = Integer.parseInt(split[0]);
						int denominator = Integer.parseInt(split[1]);

						int y = numerator1 * denominator;
						int z = denominator1 * numerator;

						if (y == z) {
							insert = false;
							counter[i]++;
						}

					}
				}

				// I use this if statement that states that the boolean insert is equal to true
				// to insert any new fractions into the fractions and
				// counter
				// array by creating a new set of arrays that are one index larger than their
				// corresponding arrays containing the same values from their corresponding
				// arrays and then make the fractions and counter arrays equal to these arrays.
				// If the fraction has a denominator of 0, I insert the fraction
				// at the last index of the fractions array and insert int -1 at the last
				// index of the counter array. Else, I insert the fraction and its counter at
				// the last index of the fractions and
				// counter array.
				if (insert == true) {
					String[] newFractions = new String[fractions.length + 1];
					int[] newCounter = new int[counter.length + 1];

					for (int i = 0; i < fractions.length; i++) {
						newFractions[i] = fractions[i];
						newCounter[i] = counter[i];
					}
					fractions = newFractions;
					counter = newCounter;
					fractions[fractions.length - 1] = line;
					if (denominator1 == 0) {
						counter[counter.length - 1] = -1;
					}

					else {
						counter[counter.length - 1] = 1;
					}
				}

			}

			readfile.close();
		}

		catch (

		Exception fileException) {
			System.out.println(fileException);
		}

		// I use this for loop to loop through the arrays of fractions and counter and
		// print
		// each unique fraction with its count if the denominator does not equal 0. If
		// it does equal 0 I do not print its count and instead print the fraction and
		// an exception situation statement.
		for (int i = 0; i < fractions.length; i++) {
			String x = fractions[i];
			String[] split = x.split("/");
			int numerator = Integer.parseInt(split[0]);
			int denominator = Integer.parseInt(split[1]);

			if (denominator != 0) {
				System.out.println(fractions[i] + " has a count of " + counter[i]);
			} else {
				System.out.println(fractions[i] + " is invalid because denominator cannot be 0!");
			}

		}

	}

}
