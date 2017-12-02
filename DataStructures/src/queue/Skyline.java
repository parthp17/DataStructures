package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Skyline {

	static class Point implements Comparable<Point>{

        int x;
        int h;
        boolean isStart;
		@Override
		public int compareTo(Point o) {
			if(this.x != o.x)
				return this.x - o.x;
			else if(this.isStart && o.isStart) 
				return o.h - this.h;
			else if(!this.isStart && !o.isStart)
				return this.h - o.h;
			else if(!this.isStart && o.isStart)
                return o.h;
            else
                return -this.h;
		}
        
		Point(int x, int h, boolean isStart)
		{
			this.x = x;
			this.h = h;
			this.isStart = isStart;
		}
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        
    	List<Point> ls = new ArrayList<>();
    	List<int[]> result = new ArrayList<>();
    	TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for(int[] arr : buildings) {
        	ls.add(new Point(arr[0],arr[2],true));
        	ls.add(new Point(arr[1],arr[2],false));
        }
        Collections.sort(ls);
        int max = 0;
        tmap.put(0, 0);
        for(Point p : ls)
        {
        	if(p.isStart)
        	{
        		tmap.put(p.h, tmap.getOrDefault(p.h, 0) + 1);
        	}
        	else
        	{
        		tmap.compute(p.h, (k,v) ->{ 
        			if(v == 1)
        				return null;
        			else
        				return v -1;
        		});
        	}
        	
        	int cmax= tmap.lastKey();
        	
        	if(cmax != max)
        	{
        		max= cmax;
        		result.add(new int[]{p.x,max});
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		
    	int [][] buildings = {{0,2,3},{2,5,3}};
        Skyline sd = new Skyline();
        
        sd.getSkyline(buildings).forEach(arr -> System.out.println(Arrays.toString(arr)));
	}
}
