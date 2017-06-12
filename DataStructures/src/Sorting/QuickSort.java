package Sorting;

public class QuickSort {

	public void quickSort(int[] arr)
	{
		if(arr == null || arr.length == 0) return;
		quickSort(arr, 0, arr.length - 1);
	}
	
	private void quickSort(int[] arr, int start, int end)
	{
		if(end <= start) return;
		
		int i = start;
		int j = end;
		int pivot = arr[(start+end)/2];
		while( i <= j)
		{
			while(arr[i] < pivot)i++;
			while(arr[j] > pivot) j--;
			if(i <= j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		quickSort(arr, start, i-1);
		quickSort(arr, i, end);
	}
}
