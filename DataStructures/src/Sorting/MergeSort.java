package Sorting;

import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> {
	
	private T helper[] = null;
	
	public void mergeSort(T[] arr, Comparator<T> c)
	{
		if(arr == null || arr.length == 0) return;
		helper  = arr.clone();
		mergeSort(arr,0,arr.length-1,c);
	}
	
	public void mergeSort(T[] arr)
	{
		if(arr == null || arr.length == 0) return;
		helper  = arr.clone();
		mergeSort(arr,0,arr.length-1);
	}
	
	private void mergeSort(T[] arr, int start, int end)
	{
		if(start < end)
		{
			int mid = (start + end )/2;
			mergeSort(arr,start, mid);
			mergeSort(arr,mid+1,end);
			doMerge(arr,start,mid,end);
		}
	}
	private void mergeSort(T[] arr, int start, int end, Comparator<T> cmp)
	{
		if(start < end)
		{
			int mid = (start + end )/2;
			mergeSort(arr,start, mid,cmp);
			mergeSort(arr,mid+1,end,cmp);
			doMerge(arr,start,mid,end,cmp);
		}
	}
	
	private void doMerge(T[] arr, int start, int mid, int end, Comparator<T> cmp)
	{
		for(int i = 0; i <=end ; i++)
			helper[i] = arr[i];
		int i ,j, k; 
		if(cmp != null)
		{
			for(i = start, j = mid+1, k = start; i <= mid && j <= end; k++)
			{
				if(cmp.compare(helper[i], helper[j]) < 0)
				{
					arr[k] = helper[i];
					i++;
				}
				else
				{
					arr[k] = helper[j];
					j++;
				}
			}
			for(; i <=mid; i++, k++)
			{
				arr[k] = helper[i];
			}
		}
		
	}
	private void doMerge(T[] arr, int start, int mid, int end)
	{
		
		for(int i = 0; i <=end ; i++)
			helper[i] = arr[i];
		int i ,j, k; 
		for(i = start, j = mid+1, k = start; i <= mid && j <= end; k++)
		{
			if(helper[i].compareTo(helper[j]) < 0)
			{
				arr[k] = helper[i];
				i++;
			}
			else
			{
				arr[k] = helper[j];
				j++;
			}
		}	
		
		for(; i <=mid; i++, k++)
		{
			arr[k] = helper[i];
		}
	}
	
	
}
