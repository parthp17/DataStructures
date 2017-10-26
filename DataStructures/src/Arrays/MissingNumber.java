package Arrays;

public class MissingNumber {

	 public int missingNumber(int[] nums) {
	        
	    int res = nums.length;
	    for(int i=0; i<nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	 }
	 
	 
	 /*int len = nums.length;
	    int sum = (0+len)*(len+1)/2;
	    for(int i=0; i<len; i++)
	        sum-=nums[i];
	    return sum;*/
}
