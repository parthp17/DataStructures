package SearchigAlgorithm;

public class MinSwapToSort {

	
	public int minSwaps(int[] arr)
	{
		class Pair implements Comparable{
			int value;
			int position;
			boolean visited;
			Pair(int val, int index)
			{
				this.value = val;
				this.position=index;
				this.visited = false;
			}
			@Override
			public int compareTo(Object o) {
				return this.value - ((Pair)o).value;
			}
		}
		Pair[] pairs = new Pair[arr.length];
		for(int i = 0;i< arr.length ;i++)
			pairs[i] = new Pair(arr[i], i);

		java.util.Arrays.sort(pairs);
		int ans = 0;
		for(int i = 0; i < pairs.length; i++)
		{
			if(pairs[i].visited || pairs[i].position == i) continue;
			
			int cycle = 0;
			int j = i;
			while(!pairs[j].visited)
			{
				pairs[j].visited = true;
				j = pairs[j].position;
				cycle++;
			}
			ans +=  cycle-1;
		}
		return ans;
	}
	
	//Same as count inversions
	public int minSwapsWithAdjOnly(int[] arr)
	{
		int[] temp = new int[arr.length];
		return mergeSort(arr, temp, 0, arr.length-1);
	}
	
	private int mergeSort(int[] arr, int[] temp, int start, int end)
	{
		int mid, inv_count = 0;
		if(start >  end)
		{
			mid = (start + end)/2;
			inv_count += mergeSort(arr, temp, 0, mid);
			inv_count += mergeSort(arr, temp, mid+1, end);
			inv_count += mergeSort(arr, temp, start, mid+1 ,end);
		}
		return inv_count;
	}
	
	private int mergeSort(int[] arr, int[] temp, int start, int mid, int end) {
		
		int inv_count=0;
		int i = start; // start of left
		int j = mid; // start of right
		int k = start; // start of temp;
		
		while((i <= mid -1) && (j <= end))
		{
			if(arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else
			{
				temp[k++] = arr[j++];
				inv_count += (mid-i); // add inv count for elements from i to left  end i.e. mid
			}
		}
		
		// copy remaining left half		
		while(i < mid )
			temp[k++] = arr[i++];
		// copy remaining right half
		while(j < end )
			temp[k++] = arr[j++];
		
		//copy back
		for(i=start; i <= end; i++)
			arr[i] = temp[i];
		
		
		return inv_count;
	}

	public static void main(String[] args) {
		MinSwapToSort msts = new MinSwapToSort();
		System.out.println(msts.minSwaps(new int[]{2,4,5,1,3}));
	}
}
