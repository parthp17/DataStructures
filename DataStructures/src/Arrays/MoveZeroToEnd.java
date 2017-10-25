package Arrays;

import java.util.Arrays;

public class MoveZeroToEnd {

	/*public void moveZeroes(int[] nums) {
        
		int count = 0;
		
		for(int i =0 ; i < nums.length ; i++)
			if(nums[i] != 0)
				nums[count++] = nums[i];
		while(count < nums.length)
			nums[count++] = 0;
		
    }*/
	
	void moveZeroes(int[] nums) {
	    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
	        if (nums[cur] != 0) {
	        	int temp  = nums[lastNonZeroFoundAt];
	        	nums[lastNonZeroFoundAt++] = nums[cur];
	        	nums[cur] = temp;
	        }
	    }
	}
	
	public static void main(String[] args) {
	
		MoveZeroToEnd mzte = new MoveZeroToEnd();
		int[] nums = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		mzte.moveZeroes(nums);
		Arrays.stream(nums).forEach(System.out::println); 
	}
}
