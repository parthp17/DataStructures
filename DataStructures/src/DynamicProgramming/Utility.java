package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {

	public static void main(String[] args)
	{
		DynamicProgramming dp = new DynamicProgramming();
		//System.out.println(dp.maxSumSubArray(new int[]{-2,-3,5,-1,2,8,-7,3,-7,6}));
		//System.out.println(dp.nthUglynumber(18));
/*		System.out.println(dp.maxSizeSubMatrixwith1(new int[][]{{0, 1, 1, 0, 1}, 
            {1, 1, 0, 1, 0}, 
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}}));
*/		//System.out.println(dp.fibonacci(5));
		/*System.out.println(dp.doesMazePathExsists(new int[][]{
			{1, 1, 1, 1, 1}, 
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 1, 0, 1}
		}));*/
		//System.out.println(dp.getfibonacci(4));
		//System.out.println(dp.getLIS(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 }));
		
		//System.out.println(dp.getLCS("AGGTAB".toCharArray(), "GXTXAYB".toCharArray()));
		
		//System.out.println(dp.editDistance("sunday", "saturday"));
		System.out.println(dp.minCostPath(new int[][]{ {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} }));
		//System.out.println(dp.largestNonRepeatingSubsting("ABDEFGABEF"));
		//System.out.println(dp.minJumps(new int[] {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}));
		//System.out.println(dp.countCoinWays(new int[]{2,3,5,6},4,10));
		//System.out.println(dp.matrixMultOperations(new int[]{40, 20, 30, 10, 30}));
		//System.out.println(dp.getBinomialCoefficent(5, 2));
		//System.out.println(dp.knapSack01(new int[]{1,4,5,7}, new int[]{1,3,4,5}, 7));
		//System.out.println(dp.eggDrop(6, 2));
		//System.out.println(dp.cuttingRod(10, new int[]{2,5,7,8}, new int[]{2,3,4,5}));
		//System.out.println(dp.maxSumSubsequence(new int[]{1, 101, 2, 3, 100, 4, 5}));
		//System.out.println(dp.longestBitonicSubsequence(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
		//System.out.println(dp.palindromicPartition("abcbm"));
		//System.out.println(dp.palindromicPartition("abcbm", 5));
		//System.out.println(dp.subsetSum(new int[]{1, 5,11, 5}));
		/*String[] format= dp.textJustification(new String[]{"Tushar","ROy","likes","to","code"}, 10);
		for(String s : format)
			if(s!=null)
			System.out.println(s);*/
		//System.out.println(dp.maxChainLength(new int[]{5,15,27,50}, new int[]{24,25,40,60}));
		//System.out.println(dp.maxValidBridges(new int[]{1,2,3,4,5,6}, new int[]{3,4,5,6,1,2}));
		//System.out.println(dp.boxStacking(new int[]{4,1,4,10}, new int[]{6,2,5,12}, new int[]{7,3,6,32}));
		//System.out.println(dp.optimalBinarySearchTree(new int[]{10,12,16,21}, new int[]{4,2,6,3}));
		//System.out.println(dp.subsetSum(new int[]{1, 5,11, 5}, 22));
		/*System.out.println(dp.maxSumRectangle(new int[][]{{1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
           }));*/
		
		//System.out.println(dp.minInsertionPalindrome("geeks"));
		//System.out.println(dp.findDiceWays(6, 3, 8));
		//System.out.println(dp.optimalGame(new int[]{20, 30, 2, 2, 2, 10}));
		/*String[] s ={"mobile","samsung","sam","sung","man","mango",
	            "icecream","and","go","i","like","ice","cream"};
		List<String> ls = new ArrayList<String>(Arrays.asList(s));
		System.out.println(dp.wordSplit("ilikessamsung", ls));*/
		//System.out.println(dp.stringInterleaving("axy", "aab", "aaxaby"));
		//System.out.println(dp.lenghtLongestArithmeticProgression(new int[]{1, 7, 10, 15, 27, 29}));
		//System.out.println(dp.minCoins(new int[]{3,5}, 4));
	}
}
