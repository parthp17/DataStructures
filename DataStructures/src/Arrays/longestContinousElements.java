package Arrays;

import java.util.HashSet;
import java.util.Set;

public class longestContinousElements {

	public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
	
	public static void main(String[] args) {
		System.out.println(new longestContinousElements().longestConsecutive(new int[]{100,4,200,1,3,2}));
	}
}
