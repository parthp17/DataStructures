package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnLine {

	 class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	 }
	 
	 class Line{
		 double slope;
		 int distance;
		 
		 public Line(double maxValue, int ax) {
			this.slope = maxValue;
			this.distance = ax;
		}

		@Override
		public int hashCode() {
			return (int) slope;
		}
		 
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return slope == ((Line)obj).slope && distance == ((Line)obj).distance;
		}
	 }
	 
	 public int maxPoints(Point[] points) {
	        
		 Map<Line, List<Point>> map = new HashMap<>();
	     double slope = 0;
	     List<Point> set = null;
	     int max = 0;
	     if(points.length == 0 || points.length == 1 || points.length == 2) return points.length;
	     Line line = null;
	     int samePt = 0;
		 for(int i = 1 ; i < points.length; i++)
		 {
			 for(int j = 0 ; j < i ; j++)
			 {
				 int ax = points[i].x;
				 int ay = points[i].y;
				 int bx = points[j].x;
				 int by = points[j].y;
				 
				 if((ax - bx) == 0 && (ay - by) != 0) 
				 {
					line = new Line(Integer.MAX_VALUE,ax);
				 }
				 else if((ax - bx) == 0 && (ay - by == 0))
				 {
					 //samePt++;
				 }
				 else
				 {
					 slope = (ay-by)/(ax-bx);
					 line  = new Line(slope, (int)slope*ax - ay);
				 }
				 
				 if(map.containsKey(line))
				 {
					 set = map.get(line);
					 if(!set.contains(points[i]))
					 set.add(points[i]);
					 if(!set.contains(points[j]))
					 set.add(points[j]);
				 }
				 else
				 {
					 set = new ArrayList<>();
					 set.add(points[i]);
					 set.add(points[j]);
					 map.put(line, set);
				 }
				 if(max < map.get(line).size())
				 {
					 max = map.get(line).size();
					 /*map.get(slope).forEach(p -> {System.out.println(p.x + " "+ p.y);});
					 System.out.println("slope " + slope);
					 System.out.println("slope size " + max);*/
				 }
			 }
		 }
		 
		 return max + samePt;
	 }
	 
	 public static void main(String[] args) {
		
		 MaxPointsOnLine mp = new MaxPointsOnLine();
		 Point[] points = new Point[4];
		 points[0] = mp.new Point(3,10);points[1] = mp.new Point(0,2);points[2] = mp.new Point(0,2);points[3] = mp.new Point(3,10);
		 /*points[0] = mp.new Point(0,-12);points[1] = mp.new Point(5,2);points[2] = mp.new Point(2,5);points[3] = mp.new Point(0,-5);
		 points[4] = mp.new Point(1,5);points[5] = mp.new Point(2,-2);points[6] = mp.new Point(5,-4);points[7] = mp.new Point(3,4);
		 points[8] = mp.new Point(-2,4);points[9] = mp.new Point(-1,4);points[10] = mp.new Point(0,-5);points[11] = mp.new Point(0,-8);
		 points[12] = mp.new Point(-2,-1);points[13] = mp.new Point(0,-11);points[14] = mp.new Point(0,-9);
		 */System.out.println(mp.maxPoints(points));
	}
}
