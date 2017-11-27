package htw.tutorium.arrays;

public class SortedArray {
	
	private int[] sorted;
	private int index;
	
	public SortedArray(int j) {
		sorted = new int[j];
		index = 0;
	}
	
	public void insert(int elem) {
		if(index == 0 || (index-1 >=0 && sorted[index-1] < elem)) {
			sorted[index] = elem;
			index++;
		}else {
			System.out.println("no way, bruh");
		}
		
	}
	
	public int search(int k) {
		int low = 0;
		int high = sorted.length-1;
		int mid;
		
		while(low <= high) {
		mid = (high + low) / 2;
			if(sorted[mid] == k) {
				return mid;
			}else if(sorted[mid] > k ) {
				high = mid -1;
			}else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public int[] returnArray() {
		return sorted;
	}
}
