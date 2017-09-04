package LeetCode;

import java.util.Random;

public class PaintHouse {

	public int minCost(int[][] costs) {
     
		for(int i = 1; i < costs.length;i++)
		{
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
		}
       return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
	
	public static void main(String[] args) {
		System.out.println(new PaintHouse().minCost(new int[][]{{7,6,8}}));
	}
	
}
