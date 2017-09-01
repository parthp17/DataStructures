package LeetCode;

public class Counting1sKNumbers {

	public int[] countBits(int num) {
    
		int[] arr = new int[num+1];
		for(int i = 0; i < arr.length ; i++)
			arr[i] = arr[i >> 1] + (i & 1);
		return arr;
    }
	
	public static void main(String[] args) {
		System.out.println(new Counting1sKNumbers().countBits(5).toString());
	}
}
