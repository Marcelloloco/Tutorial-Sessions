package htw.tutorium.arrays;

public class UnsortedArray {

	private int[] unsorted;
	private int index;
	
	public UnsortedArray(int i) {
		unsorted = new int[i];
		index = 0;
	}
	
	public void insert(int elem) {
		unsorted[index] = elem;
		index += 1;
	}
	
	public int search(int j) {
		
		for(int i = 0; i < unsorted.length; i++) {
			if(unsorted[i] == j) {
				return i;
			}
		}
		return -1;
	}
	
	public void delete(int a) {
		int deleteIndex = search(a);
		for(int i = deleteIndex; i < unsorted.length; i++) {
			if(i  < (unsorted.length - 1)) {
				unsorted[i] = unsorted[ i + 1];
			}
		}
		index--;
	}
	
	
	public int[] returnArray() {
		return unsorted;
	}
	
	
}
