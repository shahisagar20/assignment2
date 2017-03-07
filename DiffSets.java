package assignment2;
/*Sagar Shahi
 * Assignment #2 Q#2
 * This program takes three integers as parameters
 * It creates two arrays of size of  first two parameters
 * Finds the unique elements compared to each other and displays the unique elements in both
 * It repeats the same process for number of times specified by 3rd parameter
 */

import java.util.ArrayList;
import java.util.Arrays;

public class DiffSets {
	private int[] setOne;
	private int[] setTwo;
	private int[] uniqueSet;

	/*
	 * Constructor for DiffSets
	 * 
	 * @ param, integer value to create first array of that size
	 * 
	 * @ param, integer value to create second array of that size
	 * 
	 * @param, number of iterations to do the whole process
	 */
	public DiffSets(int setA, int setB, int numberOfIteration) {
		int count = 0;
		while (count < numberOfIteration) {

			int max = Math.max(setA, setB);

			setOne = new int[setA];// Initialize the array to the size of setA
			for (int i = 0; i < setA; i++) {
				setOne[i] = (int) (Math.random() * max); // Fill the first array
															// with
															// integers from
															// 0-max
			}

			Arrays.sort(setOne);// Sort the first array

			for (int i = 0; i < setOne.length; i++) { // print the first array
				System.out.println("one: " + setOne[i]);
			}

			setTwo = new int[setB];// Initialize the array to the size of the
									// setB
			for (int i = 0; i < setB; i++) { // fill the second array with
												// random elements
				setTwo[i] = (int) (Math.random() * max);

			}

			Arrays.sort(setTwo);// sort the second array

			for (int i = 0; i < setTwo.length; i++) { // print the elements in
														// second array.
				System.out.println("two: " + setTwo[i]);
			}

			int size = setOne.length + setTwo.length; // size of the array to
														// store unique elements
														// in a and b arrays
			uniqueSet = new int[size];// Initialize the uniquSet array;

			int counter = 0; // a counter
			for (int k = 0; k < setOne.length; k++) { // using binary search,
														// this loop finds
														// weather the elements
														// in setOne are in
														// setTwo or not and
														// stores them in unique
														// set.
				if (binary(setTwo, setOne[k]) < 0) {
					uniqueSet[counter] = setOne[k];
					counter++;
				}

			}
			int counter2 = 0;
			for (int j = 0; j < setTwo.length; j++) { // same as above but
				if (binary(setOne, setTwo[j]) < 0) { // finds the elements in
														// setTwo and checks if
					uniqueSet[counter2 + counter] = setTwo[j];// they are in
																// setOne or not
																// and store
																// them in
					counter2++; // uniqueset
				}
			}

			for (int i = 0; i < counter2 + counter; i++) { // prints the
															// elements in
															// uniqueSet.

				System.out.println(uniqueSet[i] + ",");

			}
			System.out.println(1 + count + "th loop "); // Counts the number of
														// iterations
			count++;

		}

	}

	/*
	 * This method does the binary search in the array
	 * 
	 * @ param Array to be searched in
	 * 
	 * @ param, value to be searched
	 * 
	 * @return, -1 if the value is not present, index of the key in the array
	 */
	private int binary(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;

	}
	/*
	 * Test program for diffset
	 */

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();// gets time at
															// beginning of the
															// program
		DiffSets n = new DiffSets(100, 100, 100);
		final long endTime = System.currentTimeMillis(); // gets time at the end
															// of the program
		System.out.println("Total execution time: " + (endTime - startTime)); // displays
																				// the
																				// time
																				// takes
																				// for
																				// execution
																				// of
																				// the
																				// program

	}

}
