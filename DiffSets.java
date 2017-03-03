package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiffSets {
	private int[] setOne;
	private int[] setTwo;
	private int[] uniqueSet;

	public DiffSets(int setA, int setB, int numberOfIteration) {
		int count = 0;
		while (count < numberOfIteration) {

			int max = Math.max(setA, setB);

			setOne = new int[setA];// Initialize the array to the size of setA
			for (int i = 0; i < setA; i++) {
				setOne[i] = (int) (Math.random() * max); // Fill the array with
															// integers from
															// 0-max
			}
			Arrays.sort(setOne);
			 for (int i =0; i<setOne.length; i ++){
			 System.out.println("one: "+setOne[i]);
			 }

			setTwo = new int[setB];// Initialize the array to the size of the
									// setB
			for (int i = 0; i < setB; i++) {
				setTwo[i] = (int) (Math.random() * max);

			}
			Arrays.sort(setTwo);
			 for (int i =0; i<setTwo.length; i ++){
			 System.out.println("two: "+setTwo[i]);
			 }
			
			int size = setOne.length + setTwo.length;
			uniqueSet = new int[size];

			int counter = 0;
			for (int k = 0; k < 4; k++) {
				if (!useArraysBinarySearch(setTwo, setOne[k])) {
					uniqueSet[counter] = setOne[k];
					counter++;
				}

			}
			int counter2 = 0;
			for (int j = 0; j < setTwo.length; j++) {
				if (!useArraysBinarySearch(setOne, setTwo[j])) {
					uniqueSet[counter2 + counter] = setTwo[j];
					counter2++;
				}
			}
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			Set<Integer> set = new HashSet<Integer>();

			for (int i = 0; i < uniqueSet.length; i++) {

				System.out.println(uniqueSet[i] + ",");

			}
			System.out.println(1 + count + "st loop ");
			count++;

		}

	}

	public static void main(String[] args) {
		DiffSets n = new DiffSets(4, 5, 1);

	}

	public static boolean useArraysBinarySearch(int[] arr, int targetValue) {
		int a = Arrays.binarySearch(arr, targetValue);
		if (a > 0)
			return true;
		else
			return false;
	}

}
