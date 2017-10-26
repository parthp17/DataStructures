package Arrays;

import java.util.Arrays;

public class RotateArray {

	public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        return nums;
    }
	
	public void rotateReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] left = new int[k];
        int[] right = new int[n-k];
        
        System.arraycopy(nums, 0, right, 0, n-k);
        System.arraycopy(nums,n-k, left, 0, k);
        System.arraycopy(left, 0, nums, 0, k);
        System.arraycopy(right, 0, nums, k, n-k);
    }
	
	public static void main(String[] args) {
		
		Arrays.stream(rotate(new int[]{1,2,3,4,5,6}, 2)).forEach(System.out::println);
	}
	
}
