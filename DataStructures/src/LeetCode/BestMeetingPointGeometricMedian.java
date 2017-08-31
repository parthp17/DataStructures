package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestMeetingPointGeometricMedian {

	public int minDistance(int[][] matrix)
	{
		int[] v = new int[matrix.length];
		int[] h = new int[matrix[0].length];
		for(int i = 0 ; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length ; j++)
			{
				if(matrix[i][j] != 0)
				{
					v[i] += matrix[i][j];
					h[j] += matrix[i][j];
				}
			}
		}
		int total = 0;
        for (int[] K : new int[][]{ v, h }) {
            int i = 0, j = K.length - 1;
            while (i < j) {
                int k = Math.min(K[i], K[j]);
                total += k * (j - i);
                if ((K[i] -= k) == 0) ++i;
                if ((K[j] -= k) == 0) --j;
            }
        }
        return total;
		
	}
	
	public static void main(String[] args) {

		BestMeetingPointGeometricMedian gm= new BestMeetingPointGeometricMedian();
		int[][] matrix = new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(gm.minDistance(matrix));
	}
	
}
