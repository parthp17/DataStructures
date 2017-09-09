package Utilities;

public class SubarraySum {

	static long subarraySum(int[] arr) {

		long answer = 0;
		int[][] matrix = new int[arr.length][arr.length];
        for(int i = 0 ; i < matrix.length; i++)
        	answer += (((long)arr[i])*(i+1)*(arr.length - i)); 

        return answer;
    }

	
}
