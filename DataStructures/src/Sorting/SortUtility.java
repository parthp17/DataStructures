package Sorting;

import java.util.Comparator;

public class SortUtility {

	/*
	 * Merge sort
	 * Quick sort
	 * Radix sort
	 * Heap sort
	 * shell sort
	 */
	
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[] {80,5,7,2,9,1};
		
		/*new MergeSort<Integer>().mergeSort(arr);
		System.out.println("Merge Sort");
		for(int i : arr)
		{
			System.out.println(i);
		}
	String[] sarr = new String[]{"Parth","Kemy","Hriday","Rini"};
		new MergeSort<String>().mergeSort(sarr);
		for(String s : sarr)
		{
			System.out.println(s);
		}
		
		new MergeSort<String>().mergeSort(sarr, new StringReverseSort());
		for(String s : sarr)
		{
			System.out.println(s);
		}*/
		int[] arrr = new int[]{41,54,62,561,893,425,230,98,13,2,399,477,544,60,789};
		/*QuickSort qs = new QuickSort();
		
		qs.quickSort( arrr);
		for(int i : arrr)
		{
			System.out.println(i);
			
		}*/
		
		/*RadixSort rs = new RadixSort();
		arrr = rs.radixSort(arrr);
		for(int i : arrr)
		{
			System.out.println(i);	
		}*/
		
		HeapSort hp = new HeapSort();
		
		hp.sort(arrr);
		for(int i : arrr)
		{
			System.out.println(i);	
		}
	}
}


class StringReverseSort implements Comparator<String>
{
	public int compare(String s1, String s2)
	{
		return s2.compareTo(s1);
	}
}