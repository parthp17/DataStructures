package Utilities;
import java.util.Arrays;

import Tree.BinarySearchTree;
import Tree.TreeNode;

public class Array {
	
	public static BinarySearchTree arrayToBST(int arr[])
	{
		
		if(arr == null || arr.length == 0 ) return null;
		Arrays.sort(arr);
		return new BinarySearchTree( arrayToBST(arr,0,arr.length-1));
	}
	
	public static TreeNode arrayToBST(int[] arr, int start, int end)
	{
		
		if(start < end) return null;
		
		int  mid = (start + end)/2;
		
		TreeNode root = new TreeNode(arr[mid]);
		root.setLeft(arrayToBST(arr, start, mid -1));
		root.setRight(arrayToBST(arr, mid+1, end));
		
		return root;
	}
	
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	     
	     int aMax = Integer.MIN_VALUE, aMin = Integer.MIN_VALUE;   
	    for(int i = 0; i < A.length - 1; i ++)
	    {
	        if(A[i] < A[i+i]) continue;
	        
	        aMax = i;
	        break;
	    }
	    if(aMax == Integer.MIN_VALUE) return 0;
	    for(int i = A.length-1; i > 0; i--)
	    {
	        if(A[i] > A[i-1]) continue;
	        aMin = i-1;
	        break;
	    }
	    
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    
	    for(int i = aMax; i <= aMin; i++)
	    {
	        if(max < A[i]) max = A[i];
	        
	        if(min > A[i]) min = A[i];
	        
	    }
	    
	    for(int i = 0 ; i < aMax; i++)
	    {
	     
	     if(A[i] > min)
	     {
	         aMax = i;
	            break;
	     }
	    }
	    aMax++;
	    for(int i = aMin + 1; i < A.length ; i++)
	    {
	        if(A[i] < max)
	        {
	         aMin = i;
	         break;
	        }
	        
	    }
	    return aMin-aMax;   
	    
	    }
	
}