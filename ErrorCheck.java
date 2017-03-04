package assignment2;

public class ErrorCheck {

	public static void main(String[] args) {
		int [] arr = {1,2,3,25,35,45,55,65};
		System.out.println(binary(arr,55));
	}

	public static int binary(int[] a, int key){
		int lo = 0;
        int hi = a.length - 1;

		        while (lo <= hi) {
		            // Key is in a[lo..hi] or not present.
		            int mid = lo + (hi - lo) / 2;
		            if      (key < a[mid]) hi = mid - 1;
		            else if (key > a[mid]) lo = mid + 1;
		            else return mid;
		        }
		        return -1;
		
	}
}
