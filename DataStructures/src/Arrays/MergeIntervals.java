package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        int[] start = new int[len];
        int[] end = new int[len];
        int index = 0;
        for(Interval i : intervals){
            start[index] = i.start;
            end[index] = i.end;
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<Interval> res = new ArrayList<Interval>();
        for(int i = 0, j = 0; i<len; i++){
            if (i == len - 1 || start[i + 1] > end[i]) {
    			res.add(new Interval(start[j], end[i]));
    			j = i + 1;
		    }
        }
        return res;
    }
}
