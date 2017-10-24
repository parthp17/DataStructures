package Arrays;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		Iterator<Integer> itr = map.keySet().iterator();
		k = nums.length - k;
		int i = 0;
		while (itr.hasNext() && k >= 0) {
			k -= map.get(i = itr.next());
		}
		return i;
	}

	public static void main(String[] args) {
		KthLargestElement k = new KthLargestElement();
		System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
}
