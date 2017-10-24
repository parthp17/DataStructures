package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TripleSum {

	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> container= new ArrayList<List<Integer>>();
		for(int i=0 ; i < nums.length-2; i++)
		{
            if(i > 0 && nums[i] == nums[i-1]) continue;
			int l = nums[i];
			for(int j = i+1, k = nums.length - 1; j < k;)
			{
                if(j != i+1 && nums[j] == nums[j-1])
                {
                	j++;
                	continue;
                }
				int total = l + nums[j] + nums[k]; 
				if(total == 0)
				{
					List<Integer> list = new ArrayList<>();
					list.add(l);
					list.add(nums[j]);
					list.add(nums[k]);
					//if(!container.contains(list))
					container.add(list);
					j++;
				}
				else if(total  < 0)
				{
					j++;
				}
				else
				{
					k--;
				}
			}
		}
		return container;
    }
	
	public static void main(String[] args) {
		
		TripleSum ts = new TripleSum();
		List<List<Integer>> ls = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		for(List<Integer> l : ls)
			System.out.println(l.toString());
	}
}
