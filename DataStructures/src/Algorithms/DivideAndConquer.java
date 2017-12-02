package Algorithms;

import java.util.Arrays;

public class DivideAndConquer {

	public int medianofTwoEqualSortedArray(int[] arr1, int[] arr2)
	{
		int s1 = 0,s2 =0;
		int e1 = arr1.length -1, e2 = arr2.length-1;
		int m1, m2 ;
		while(e1-s1 > 1)
		{
			m1 = arr1[(s1+e1+1) >> 1];
			m2 = arr2[(s2+e2+1) >> 1];
			System.out.println(m1 + " " + m2);
			if(m1 == m2) return m1;
			else if(m1 < m2)
			{
				s1 = (s1+e1+1) >> 1;
				e2 = (s2+e2+1) >> 1;
			}
			else
			{
				e1 = (s1+e1+1) >> 1;
				s2 = (s2+e2+1) >> 1;
			}
		}
		
		if( e1 == s1) return (arr1[e1]+ arr2[e1])/2;
		else if (e1 - s1 == 1) return (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2]))/2;
		else
			return Integer.MIN_VALUE;
	}
	
	
	public int medianofTwoSortedArray(int arr1[], int arr2[])
	{
		
		int m = arr1.length;
		int n = arr2.length;
		int imin = 0;
		int imax = m;
		if(m > n) return medianofTwoSortedArray(arr2, arr1);
		while(imin <= imax)
		{
			int i = imin + (imax - imin)/2;
			int j = (m + n + 1)/2 - i;
			
			int a1Left = i == 0? Integer.MIN_VALUE:arr1[i-1];
			int a1Right = i == m? Integer.MAX_VALUE:arr1[i];
			int a2Left = j == 0? Integer.MIN_VALUE:arr2[j-1];
			int a2Right = j == n? Integer.MAX_VALUE:arr2[j];
			
			if(a1Left > a2Right) imax = i-1;
			else if(a2Left > a1Right) imin = i+1;
			else
			{
				if((m+n)%2 == 1)
				{
					return Math.max(a2Left, a1Left);
				}
				else
					return (Math.max(a2Left, a1Left) + Math.min(a1Right, a2Right)) >> 1;
			}
		}
		return -1;
	}
	
	public int medianKSortedArray(int[][]matrix)
	{
		int m = matrix.length;
		int n = matrix.length;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < m ; i++)
		{
			min = min < matrix[i][0] ? min : matrix[i][0];
			max = max > matrix[i][n-1] ? max : matrix[i][n-1];
		}
		
		int median = (m*n + 1) / 2;
		
		while(min < max)
		{
			int mid = (min + max)/2;
			int place = 0;
			int get = 0;
			for(int i = 0 ; i < m ; ++i)
			{
				get = Arrays.binarySearch(matrix[i], mid);
				
				if(get < 0)
					get = Math.abs(get) - 1;
				else
					while(get < matrix[i].length && matrix[i][get] == mid) get += 1;
				place +=get;				
			}
			if(place < median)
				min = mid + 1;
			else
				max  = mid;
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		
		DivideAndConquer dc = new DivideAndConquer();
		int matrix[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
		System.out.println(dc.medianKSortedArray(matrix));
	}
}
