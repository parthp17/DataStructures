package LeetCode;

public class MaxSumSubArray {
	public int maxSubArray(int[] nums) {
		int maxOverAll = Integer.MIN_VALUE;
        int maxHere = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
        	if(maxHere < 0)
        		maxHere = nums[i];
        	else
        		maxHere += nums[i];
        				
        	if(maxOverAll < maxHere) maxOverAll = maxHere;			
        }
        return maxOverAll;
		/*int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int max = arr[0];
        for(int i = 1; i < n ; i++)
        {
        	arr[i] = nums[i] + (arr[i-1] > 0 ? arr[i-1] : 0);
        	if(max < arr[i])
        	{
        		max = arr[i];
        		end = i;
        	}
        }
       if(max < 0)
    	   System.out.println("Sub array is" + end);
       else
       {
    	   for(int i = end; i >= 0 ; i--)
    		   if(arr[i] <= 0){
    			   start = i + 1;
    			   break;
    		   }
    	   System.out.println("Sub array is from index "+ start + " to " + end);
       }
        return max;*/
    }
	
	public static void main(String[] args) {
		
		System.out.println(new MaxSumSubArray().maxSubArray(new int[]{-5,-2,-3}) );
	}
	
}
