package HackerRank.HomeAway;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReachingPoints {

static String canReach(int x1, int y1, int x2, int y2) {
		
	if(x1 == x2 && y1 == y2) return "Yes";
	else if(x1 > x2 ||  y1 > y2) return "No";
	else
		if(canReach(x1+y1,y1,x2,y2).equals("Yes") || canReach(x1,x1+y1,x2,y2).equals("Yes"))  return "Yes";
		else return "No";
    }
	
	public static void main(String[] args) {
		System.out.println(canReach(1,4,5,9));
	}
}
