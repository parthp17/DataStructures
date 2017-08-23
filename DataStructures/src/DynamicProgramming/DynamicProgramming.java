package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import Tree.TreeNode;
import Utilities.StringUtility;


public class DynamicProgramming {

	public int maxSumSubArray(int[] arr)
	{
		int maxSoFar = Integer.MIN_VALUE;
		int maxAt = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			maxAt += arr[i];
			if(maxAt < 0) maxAt = 0;
			if(maxAt > maxSoFar) maxSoFar = maxAt;
		}		
		return maxSoFar;
	}
	
	public int nthUglynumber(int n)
	{
		int[] arr = new int[n];
		int i2=0,i3=0,i5 = 0;
		arr[0] = 1;
		int next = 0;
		int nextUglyFor2,nextUglyFor5,nextUglyFor3;
		for(int i = 0; i < n-1; i ++)
		{
			nextUglyFor2 = arr[i2]*2;
			nextUglyFor3 = arr[i3]*3;
			nextUglyFor5 = arr[i5]*5;
			next = Math.min(nextUglyFor2, nextUglyFor3);
			arr[i+1] = Math.min(nextUglyFor5, next);
			if(arr[i+1] == nextUglyFor2)
				i2++;
			if(arr[i+1] == nextUglyFor3)
				i3++;
			if(arr[i+1] == nextUglyFor5)
				i5++;
		}
		return arr[n-1];
	}
	
	public int maxSizeSubMatrixwith1(int[][] matrix)
	{
		int[][] sumMatrix = new int[matrix.length][matrix[0].length];
		int maxSize = 0;
		for(int i = 0; i < matrix[0].length; i++)
		{
			sumMatrix[0][i] = matrix[0][i];
			sumMatrix[i][0] = matrix[i][0];
			if(maxSize == 0 && (sumMatrix[0][i] == 1 || sumMatrix[i][0] == 1)) maxSize = 1;
		}
		
		for(int i =1;i < matrix.length;i++)
		{
			for(int j =1; j< matrix[0].length; j++)
			{
				if(matrix[i][j] == 1)
				{
					sumMatrix[i][j] = Math.min(sumMatrix[i][j-1],sumMatrix[i-1][j-1] );
					sumMatrix[i][j] = Math.min(sumMatrix[i][j],sumMatrix[i-1][j]) + 1;
					maxSize = (maxSize > sumMatrix[i][j]) ? maxSize : sumMatrix[i][j];
				}
				else
				{
					sumMatrix[i][j] = 0;
				}
			}
		}
		return maxSize;
	}
	
	public int fibonacci(int n)
	{
		/*
		 * Tabulation
		 */
		if(n == 0) return 0;
		if(n == 1) return 1;
		int a = 0;
		int b = 1;
		int c=0;
		for(int i = 1; i < n ; i++ )
		{
			c = a+b;
			a = b;
			b =c;
		}
		return c;
	}
	
	public int getfibonacci(int n)
	{
		int[] memo = new int[n+1];
		for(int i = 0; i < n+1; i++)
			memo[i] = -1;
		memo[0] = 0;
		memo[1] = 1;
		return getfibonacci(n, memo);
	}
	public int getfibonacci(int n, int[] memo)
	{
		if(n < 0) return -1;
		if(memo[n] != -1)
		{
			return memo[n];
		}
		memo[n] = getfibonacci(n-1, memo) + getfibonacci(n-2, memo);
		return memo[n];
	}
	
	class Index {
		public Index(int row, int col) {
			this.row = row;
			this.col = col;
		}
		int row;
		int col;
		boolean val;
		public boolean equals(Object o)
		{
			if(o instanceof Index && ((Index) o).row == this.row && ((Index) o).col==this.col )return true;
			else
			return false;
		}
		public int hashCode() {
            int result = row*13 + col*17;
            return result;
        }
	}
	public boolean doesMazePathExsists(int[][] arr)
	{
		HashSet<Index> notAllowed = new HashSet<Index>();
		int row = 0;
		int col = 0;
		ArrayList<Index> ls= new ArrayList<Index>();
		StringJoiner sj = new StringJoiner("<-");
		if(row == arr.length-1 && col == arr[0].length-1)return true;
		if(arr[row][col] == 1 && arr[arr.length-1][arr[0].length-1] == 1)
		{
			if(row+1 < arr.length && arr[row+1][col] == 1 && doesMazePathExsists(arr, row+1, col, notAllowed,ls))
			{
				ls.forEach(i -> sj.add(i.row +","+i.col));
				System.out.println(sj.toString());
				return true;
			}
			if(col + 1 < arr[0].length && arr[row][col+1] == 1 && doesMazePathExsists(arr, row, col+1, notAllowed,ls))
			{
				ls.forEach(i -> sj.add(i.row +","+i.col));
				System.out.println(sj.toString());
				return true;
			}
		}
		return false;
	}
	private boolean doesMazePathExsists(int[][] arr, int row, int col, HashSet<Index> notAllowed,ArrayList<Index> ls)
	{
		if(row == (arr.length-1) && col == (arr[0].length-1))
		{
			ls.add(new Index(row, col));
			return true;
		}
		if(row+1 <arr.length &&  arr[row+1][col] == 1 && !notAllowed.contains(new Index(row+1,col)) && doesMazePathExsists(arr, row+1, col, notAllowed,ls))
		{
			ls.add(new Index(row, col));
			return true;
		}
		if(col+1 < arr[0].length && arr[row][col+1] == 1 && !notAllowed.contains(new Index(row,col+1)) && doesMazePathExsists(arr, row, col+1, notAllowed,ls))
		{
			ls.add(new Index(row, col));
			return true;
		}
		notAllowed.add(new Index(row,col));
		return false;	
	}
	
	public int getLIS(int[] arr)
	{
		//longest increasing subsequence
		int[] lis = new int[arr.length];
		int maxLength = 1;
		for(int i = 0; i < arr.length; i++)
		lis[i] = 1;
		for(int i = 1; i < arr.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(arr[j] < arr[i] && lis[i] <= lis[j])
				{
					lis[i] =lis[j] +1;
					maxLength = (maxLength > lis[i])? maxLength : lis[i];
				}
			}
		}
		System.out.println(lis[lis.length-1]);
		return maxLength;
	}
	
	public String getLCS(char[] arr1, char[]arr2)
	{
		int[][] matrix = new int[arr2.length+1][arr1.length+1];
		int max = 0;
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length ; j++)
			{
				if(i==0 || j ==0 ) matrix[i][j] = 0;
				else if(arr2[i-1] == arr1[j-1])
				{
					matrix[i][j] = matrix[i-1][j-1] + 1;
					if(matrix[i][j] > max)
					{
						max=matrix[i][j];
						s.append(arr2[i-1]);
					}
				}
				else
					matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
			}
		}
		int i = matrix.length, j = matrix[0].length; 
		System.out.println(max);
		return s.toString();
	}
	
	public int editDistance(String s1, String s2)
	{
		/*
		 * convert s1 to s2
		 * operations allowed - Insert, Replace, Remove
		 */
		int[][] distanceMatrix = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < s1.length();i++)
			distanceMatrix[i][0] = i;
		for(int i = 0; i < s2.length(); i++)
			distanceMatrix[0][i] = i;
		for(int i =1 ; i < distanceMatrix.length ; i++)
		{
			for(int j = 1 ; j < distanceMatrix[0].length; j++)
			{
				if(s1.charAt(i-1) == s2.charAt(j-1))
					distanceMatrix[i][j] = distanceMatrix[i-1][j-1];
				else
				{
					distanceMatrix[i][j] = Math.min(distanceMatrix[i-1][j],distanceMatrix[i][j-1]);
					distanceMatrix[i][j] = Math.min(distanceMatrix[i][j],distanceMatrix[i-1][j-1]) + 1;
				}
			}
		}
		
		return distanceMatrix[distanceMatrix.length-1][distanceMatrix[0].length-1];
	}
	
	public int minCostPath(int[][] path)
	{
		int[][] dist = new int[path.length][path[0].length];
		dist[0][0] = path[0][0];
		for(int i = 1; i < path.length; i++)
			dist[i][0] = path[i][0] + dist[i-1][0];
		for(int i = 1; i < path.length; i++)
			dist[0][i] = path[0][i] + dist[0][i-1];
		for(int i = 1; i < path.length ; i++)
		{
			for(int j = 1 ; j < path[0].length; j++)
			{
				dist[i][j] = path[i][j] + Math.min(Math.min(dist[i-1][j-1], dist[i-1][j]), dist[i][j-1]);
			}
		}
		return dist[dist.length-1][dist[0].length-1];
	}
	
	public int largestNonRepeatingSubsting(String s)
	{
		int max = 1;
		int currLen = 1;
		int[] visited = new int[256];
		Arrays.fill(visited, -1);
		visited[s.charAt(0)] = 0;
		for(int  i = 1; i < s.length(); i++)
		{
			int prev = visited[s.charAt(i)];
			if(prev == -1 || i-currLen > prev)
			{
				currLen++;
			}
			else
			{
				if(currLen > max) max = currLen;
				currLen = i - prev;
			}
			visited[s.charAt(i)] = i;
		}
		if(currLen > max) max =currLen;
		return max;
	}
	
	public int minJumps(int[] arr)
	{
		int[] jumps  = new int[arr.length];
		jumps[0] = 0;
		for(int i = 1; i < arr.length; i++)
		{
			jumps[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++)
			{
				if(j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE)
				{	
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[jumps.length -1];
	}
	
	public long countCoinWays(int[] arr, int m, int total)
	{
		long[] table = new long[total+1];
		Arrays.fill(table, 0); // O(n)
		table[0] = 1;
		
		for(int i = 0; i< m; i++)
		{
			for(int j = arr[i]; j <= total ; j++ )
			{
				table[j] += table[j - arr[i]];
			}
		}
		return table[total];
	}
	
	public int matrixMultOperations(int[] matSize)
	{
		int[][] operations = new int[matSize.length][matSize.length];
		/*for(int i = 0; i < matSize.length; i++)
			operations[i][i] = 0;*/
		int q = 0;
		for(int l = 2; l < matSize.length ; l++)
		{
			for(int i = 0; i < matSize.length -l;i++)
			{
				int j = i+l;
				operations[i][j] = Integer.MAX_VALUE;
				for(int k = i+1; k < j; k++)
				{
					q = operations[i][k] + operations[k][j] + matSize[i]*matSize[k]*matSize[j];
					operations[i][j] = Math.min(operations[i][j], q);
				}
			}
		}
		return operations[0][operations[0].length-1];
	}
	
	
	public int getBinomialCoefficent(int n, int r)
	{
		int[] arr = new int[r+1];
		arr[0] = 1;
		for(int i = 1; i <= n; i++)
		{
			for(int j = Math.min(i, r); j > 0; j--)
				arr[j] = arr[j] + arr[j-1];
		}
		return arr[r];
	}
	

	public int getBinomialCoefficent(int n, int r, int[][] arr) {
		//if(arr[r] != -1) return arr[r];
		if(arr[n][r] == 0)
		{
			if( r == 0 || r == n)
			{
				arr[n][r] = 1;
				return arr[n][r];
			}
			else arr[n][r] = getBinomialCoefficent(n-1,r-1,arr) + getBinomialCoefficent(n-1, r,arr);
		}
		return arr[n][r];
		
	}
	
	public int knapSack01(int[] val,int[] weight, int maxWeight)
	{
		int[][] matrix = new int[val.length+1][maxWeight+1];
		for(int i = 1 ; i < matrix.length ; i++)
		{
			for(int j = 0 ; j < matrix[0].length; j++)
			{
				if(weight[i-1] > j)
					matrix[i][j] = matrix[i-1][j];
				else
				{
					matrix[i][j] = Math.max(val[i-1] + matrix[i-1][j-weight[i-1]], matrix[i-1][j]);
				}
			}
		}
		int i=matrix.length-1, j=matrix[0].length-1;
		do
		{
			if(matrix[i][j] != matrix[i-1][j])
			{
				System.out.println("Value: " + val[i-1]+ "Weight: "+weight[i-1]);
				j -= weight[i-1]; 
			}
			i = i-1;
		}while(i!=0 || j != 0 );
		return matrix[matrix.length-1][matrix[0].length-1];
				
	}
	
	public int eggDrop(int floors, int eggs)
	{
		int[][] map = new int[eggs+1][floors+1];
		for(int i = 0; i < map[0].length; i++ )
		{
			map[0][i] = 0;
			map[1][i] = i;
		}
		for(int i=2 ; i < map.length;i++)
		{
			for(int j = 0; j < map[0].length ; j++)
			{
				if(i > j)
					map[i][j] = map[i-1][j];
				else
				{
					map[i][j] = Integer.MAX_VALUE;
					int q = 0;
					for(int k = 1; k <= j ; k++)
					{
						q = 1+Math.max(map[i][j-k], map[i-1][k-1]);
						map[i][j] = Math.min(q, map[i][j]);
					}
				}
			}
		}
		
		return map[map.length-1][map[0].length-1];
	}
	
	public int cuttingRod(int len, int[] profit, int[] sublen)
	{
		int[][] maxProfit = new int[sublen.length][len + 1];
		for(int i = 0;i < maxProfit[0].length; i++)
		{
			if(sublen[0] > i || i%sublen[0] != 0) continue;
			else
			{
				maxProfit[0][i] = (i/sublen[0])*profit[0];
			}
		}
		
		for(int i = 1; i < maxProfit.length ; i++)
		{
			for(int j = 1; j < maxProfit[0].length; j++)
			{
				maxProfit[i][j] = maxProfit[i-1][j];
				if(sublen[i] <= j)
				{
					int q = profit[i] + maxProfit[i][j-sublen[i]];
					maxProfit[i][j] = Math.max(maxProfit[i][j], q);
				}
			}
		}
		int i = maxProfit.length-1, j = maxProfit[0].length-1;
		int count = 0 ;
		while(i > 0 && j > 0)
		{
			if(maxProfit[i][j] == maxProfit[i-1][j]) 
			{
				i = i-1;continue;
			}
			System.out.println("Piece: " + sublen[i]);
			count += sublen[i];
			j = j-sublen[i];
		}	
		if(count != len)
			System.out.println("Piece: " + sublen[0]);
		return maxProfit[maxProfit.length-1][maxProfit[0].length -1];
	}
	
	public int maxSumSubsequence(int[] arr)
	{
		int[]  max  = new int[arr.length];
		int[] index  = new int[arr.length];
		int maxVal = Integer.MIN_VALUE;
		for(int i =0 ; i < arr.length ; i++)
		{
			max[i] = arr[i];
			maxVal = Math.max(maxVal, max[i]);
			index[i] = i;
		}
		
		for(int i = 1; i < arr.length ; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(arr[j] < arr[i] && (max[j] + arr[i]) > max[i])
				{
					max[i] = max[j] + arr[i];
					index[i] = j;
					maxVal = Math.max(maxVal, max[i]);
				}
			}
		}
		int indx = 0;
		for(; indx < max.length; indx++)
			if(maxVal == max[indx])break;
		int prev = indx;
		do{
			System.out.println(arr[indx]);
			prev = indx;
			indx = index[indx];
		}while(indx!=prev);
		return maxVal;
	}
	public int longestBitonicSubsequence(int[] arr)
	{
		int[] forward = new int[arr.length];
		int[] reverse = new int[arr.length];
		Arrays.fill(forward, 1);
		Arrays.fill(reverse, 1);
		for(int i = 1 ; i < arr.length ; i++)
		{
			for(int j = 0; j < i ; j++ )
			{
				if(arr[i] > arr[j] && forward[i] <= forward[j])
				{
					forward[i] = forward[j] +1;
				}
			}
		}
		for(int i = arr.length - 2 ; i >= 0 ; i--)
		{
			for(int j = arr.length - 1; j > i ; j-- )
			{
				if(arr[i] > arr[j] && reverse[i] <= reverse[j])
				{
					reverse[i] = reverse[j] +1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < arr.length ; i++)
		{
			max = Math.max(max, forward[i] + reverse[i] - 1);
		}
		return max;
	}
	
	public int palindromicPartition(String s)
	{
		int[][] matrix = new int[s.length()][s.length()];
		
		for(int l = 1 ; l < matrix.length;l++)
		{
			for(int i = 0; i < matrix.length - l; i++)
			{
				int j = i+l;
				if(StringUtility.isPalindrome(s.substring(i, j+1)))
					matrix[i][j] = 0;
				else
				{
					matrix[i][j] = Integer.MAX_VALUE;
					for(int k = i;k < j ; k++)
					{
						matrix[i][j] = Math.min(matrix[i][j], 1 + matrix[i][k] + matrix[k+1][j]);
					}
				}
			}
		}
		return matrix[0][matrix[0].length-1];
	}
	
	public int palindromicPartition(String s, int len)
	{
		int[] imatrix = new int[len];
		boolean[][] bmatrix= new boolean[len][len];
		for(int j = 0; j < len ; j++) bmatrix[j][j] = true;
		
		for(int l = 2; l <= len; l++)
		{
			for(int i =0 ; i < len - l + 1; i++)
			{
				int j = i+l -1;
				if(l == 2) bmatrix[i][j] = (s.charAt(i) == s.charAt(j));
				else
					bmatrix[i][j] = bmatrix[i+1][j-1] && (s.charAt(i) == s.charAt(j));
			}
		}
		
		for(int i =0; i < len ; i++)
		{
			if(bmatrix[0][i]) imatrix[i] = 0;
			else
			{
				imatrix[i] = Integer.MAX_VALUE;
				for(int j = 0; j < i;j++)
				{
					if(bmatrix[j+1][i] && 1+imatrix[j]< imatrix[i])
						imatrix[i] = 1+imatrix[j];
				}
			}
		}
		return imatrix[len-1];
	}
	
	public boolean subsetSum(int[] arr)
	{
		int len = arr.length;
		int sum = 0;
		for(int i =0; i < len ; i++)sum += arr[i];
		if((sum & 1) != 0) return false;
		sum /=2;
		boolean[][] matrix =new boolean[len+1][sum+1];
		for(int i = 0; i < matrix[0].length ; i++) matrix[0][i] = false;
		for(int i =0; i < matrix.length ; i++) matrix[i][0] = true;
		
		
		for(int i = 1; i < matrix.length ; i++)
		{
			for(int j = 1; j < matrix[0].length; j++)
			{
				if(arr[i-1] > j)
					matrix[i][j] = matrix[i-1][j];
				else
				{
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-arr[i-1]];
				}
			}
		}
		return matrix[matrix.length -1][matrix[0].length-1];
	}
	public boolean subsetSum(int[] arr, int sum)
	{
		int len = arr.length;
		boolean[][] matrix =new boolean[len+1][sum+1];
		for(int i = 0; i < matrix[0].length ; i++) matrix[0][i] = false;
		for(int i =0; i < matrix.length ; i++) matrix[i][0] = true;
		
		
		for(int i = 1; i < matrix.length ; i++)
		{
			for(int j = 1; j < matrix[0].length; j++)
			{
				if(arr[i-1] > j)
					matrix[i][j] = matrix[i-1][j];
				else
				{
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-arr[i-1]];
				}
			}
		}
		return matrix[matrix.length -1][matrix[0].length-1];
	}
	
	public String[] textJustification(String[] words, int linelen)
	{
		int[][] cost = new int[words.length][words.length];
		
		for(int i =0; i < cost.length; i++)
		{
			cost[i][i] = linelen - words[i].length();
			for(int j = i+1; j < cost[0].length ; j++)
			{
				cost[i][j] = cost[i][j-1] - words[j].length() - 1;
			}
		}
		
		for(int i =0; i < cost.length; i++)
		{
			for(int j = i; j < cost[0].length ; j++)
			{
				if(cost[i][j] < 0) cost[i][j] = Integer.MAX_VALUE;
				else
				{
					cost[i][j] = (int)Math.pow(cost[i][j], 2);
				}
			}
		}
		
		int[] minCost = new int[words.length];
		int[] result = new int[words.length];
		
		for(int i = words.length-1; i >= 0 ; i-- )
		{
			minCost[i] = cost[i][words.length - 1];
			result[i] = words.length;
			for(int j = words.length - 1 ; j > i ; j--)
			{
				if(cost[i][j-1] == Integer.MAX_VALUE) continue;
				if(minCost[i] > minCost[j] + cost[i][j-1])
				{
					minCost[i] = minCost[j] + cost[i][j-1];
					result[i] = j;
				}
			}
		}
		
		String[] format = new String[linelen];
		for(int i = 0 ; i < words.length ; i++)
		{
			int index = result[i] - 1;
			if(format[index] == null)
				format[index] = words[i];
			else
			{
				format[index] += " "+words[i];
			}
		}
		return format;
	}
	
	class Bridge
	{
		int ep1;
		int ep2;
	
		Bridge(int ep1,int ep2)
		{
			this.ep1 = ep1;
			this.ep2= ep2;
		}	
	}
	class BridgeComparator implements Comparator<Bridge>
	{
		@Override
		public int compare(Bridge b1, Bridge b2) {
			if(b1.ep2 == b2.ep2)
			{
				return b1.ep1 - b2.ep1;
			}
			else
				return b1.ep2 - b2.ep2;
		}
	}
	
	
	public int maxChainLength(int[] ep1,int[] ep2)
	{
		//LIS variation
		Bridge[] bridge = new Bridge[ep1.length];
		for(int i =0; i < bridge.length ; i++)
			bridge[i] = new Bridge(ep1[i],ep2[i]);
		
		int[] arr = new int[bridge.length];
		Arrays.fill(arr,1);
		int max = 1;
		for(int i = 1; i < bridge.length; i++)
		{
			for(int j = 0;j<i; j++)
			{
				if(bridge[i].ep1 > bridge[j].ep2 && arr[i] < arr[j] + 1)
					arr[i] = arr[j] + 1;
			}
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	
	public int maxValidBridges(int[] north, int[] south)
	{
		Bridge[] bridge = new Bridge[north.length];
		for(int i =0; i < bridge.length ; i++)
			bridge[i] = new Bridge(north[i],south[i]);
		Arrays.sort(bridge,new BridgeComparator());
		int[] arr = new int[bridge.length];
		Arrays.fill(arr, 1);
		int max = 1;
		
		for(int i = 1 ; i < arr.length; i ++)
		{
			for(int j = 0 ; j < i ; j++)
			{
				if(bridge[i].ep1 > bridge[j].ep1 && arr[i] < arr[j] + 1)
					arr[i] = arr[j] + 1;
			}
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	class Box implements Comparable<Box>
	{
		int l;
		int b;
		int h;
		Box(int l, int b,int h)
		{
			this.l = l;
			this.b = b;
			this.h = h;
		}
		@Override
		public int compareTo(Box o) {
			return (o.l*o.b - this.l*this.b);
		}
	}
	public int boxStacking(int[] l, int[] b, int[] h)
	{
		Box[] box = new Box[3*l.length];
		int k = 0;
		for(int i = 0;i < l.length; i++)
		{
			box[k++] = new Box(l[i],b[i],h[i]);
			box[k++] = new Box(l[i],h[i],b[i]);
			box[k++] = new Box(b[i],h[i],l[i]);
		}
		Arrays.sort(box);
		int[] maxHeight = new int[box.length];
		for(int i = 0 ; i < box.length; i++)
			maxHeight[i] = box[i].h;
		int[] placement = new int[box.length];
		int max = 0;
		for(int i = 1; i < box.length ; i ++)
		{
			for(int j =0; j < i ; j++)
			{
				if(box[i].l < box[j].l && box[i].b < box[j].b && maxHeight[i] < maxHeight[j] +box[i].h)
				{
					maxHeight[i] = maxHeight[j] + box[i].h;
					max = Math.max(max, maxHeight[i]);
					placement[i] = j;
				}
			}
		}
		return max;
	}
	
	public int optimalBinarySearchTree(int[] nodes, int[] frequency)
	{
		
		int[][] cost = new int[nodes.length][nodes.length];
		int[][] roots = new int[nodes.length][nodes.length];
		for(int i = 0; i < cost.length; i++)
		{
			cost[i][i] = frequency[i];
			roots[i][i] = i;
		}
		for(int l = 2 ; l <= cost.length ; l ++)
		{
			for(int i = 0; i <= cost.length-l; i++)
			{
				int j = i+l-1;
				cost[i][j] = getSum(frequency,i,j);
				int min = Integer.MAX_VALUE;
				for(int root =i; root <= j ; root++)
				{
					if(root==i)
					{
						if(min > cost[root+1][j])
						{
							min = cost[root + 1][j];
							roots[i][j] = root;
						}
					}
					else if(root == j)
					{
						if(min > cost[i][root-1])
						{
							min = cost[i][root-1];
							roots[i][j] = root;
						}
					}
					else
					{
						if(cost[root+1][j] + cost[i][root-1] < min)
						{
							min = cost[root+1][j] + cost[i][root-1];
							roots[i][j] = root;
						}
					}
				}
				cost[i][j] += min;
			}
		}
		return cost[0][cost.length-1];
	}

	private int getSum(int[] frequency, int i, int j) {
		int sum = 0;
		for(; i <=j ; i++)
			sum += frequency[i];
		return sum;		
	}
	
	class TreeNodeLIS extends TreeNode
	{
		public TreeNodeLIS() {
			super(0);
		}
		int lis;
	}
	public int LISS(TreeNodeLIS root)
	{
		if(root == null) return 0;
		if(root.lis != 0) return root.lis;
		
		if(root.getLeft()== null && root.getRight() == null)
		{
			root.lis = 1;
			return root.lis;
		}
		int lisex = LISS((TreeNodeLIS)root.getLeft()) + LISS((TreeNodeLIS)root.getRight());
		int lisin = 1;
		if(root.getLeft() != null)
			lisin += LISS((TreeNodeLIS)root.getLeft().getLeft()) + LISS((TreeNodeLIS)root.getLeft().getRight());
		if(root.getRight() != null)
			lisin += LISS((TreeNodeLIS)root.getRight().getLeft()) + LISS((TreeNodeLIS)root.getRight().getRight());
		root.lis = Math.max(lisex, lisin);
		return root.lis;
	}
	
	public int maxSumRectangle(int[][] matrix)
	{
		int[] arr = new int[matrix.length];
		int maxSum = Integer.MIN_VALUE;
		int right= 0,left=0,up=0,down=0;
		
		
		for(int l = 0; l < matrix[0].length; l++)
		{
			Arrays.fill(arr, 0);
 			for(int r = l; r < matrix[0].length; r++)
			{
				for(int i = 0 ; i < matrix.length; i++)
					arr[i] += matrix[i][r];
				int maxAt = 0;
				int maxSoFar = Integer.MIN_VALUE;
				int start = -1,end = -1, curStart= 0;
				for(int i = 0; i < arr.length; i++)
				{
					maxAt += arr[i];
					if(maxAt < 0)
					{
						maxAt = 0;
						curStart = i+1;
					}
					if(maxAt > maxSoFar)
					{
						maxSoFar = maxAt;
						start = curStart;
						end = i;
					}
				}
				if(maxSoFar > maxSum)
				{
					maxSum = maxSoFar;
					left = l;
					right = r;
					up = start;
					down= end;
				}
			}
		}
		System.out.println("start row: " + up + "start column: "+ left + "end row: "+ down + "end column: "+ right);
		return maxSum;
	}
	public int minInsertionPalindrome(String s)
	{
		int len = s.length();
		int[][] matrix = new int[len][len];
		
		for(int gap = 1; gap < len; ++gap)
		{
			for(int l = 0, h = gap; h < len; ++l, ++h)
			{
				matrix[l][h] = s.charAt(l) == s.charAt(h)? matrix[l+1][h-1]:
					(Math.min(matrix[l][h-1], matrix[l+1][h]) + 1);
			}
		}
		return matrix[0][matrix[0].length-1];
	}
	
	public int findDiceWays(int m, int n, int sum)
	{
		int[][] table = new int[n+1][sum+1];
		
		for(int i = 1; i <= m && i <= sum; i++)
		table[1][i] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			for(int j = 1; j <= sum; j++)
			{
				for(int k = 1; k <= m && k < j; k++)
				{
					table[i][j] += table[i-1][j-k]; 
				}
			}
		}
		return table[n][sum];
	}
	
	class Element
	{
		int first;
		int second;
		Element(int f, int s)
		{
			this.first = f;
			this.second = s;
		}
		
	}
	
	public int optimalGame(int[] arr)
	{
		int len = arr.length;
		Element[][] mat = new Element[len][len];
		for(int i =0 ; i < arr.length ; i++)
		{
			mat[i][i] = new Element(arr[i], 0);
		}
		for(int l = 2; l <= arr.length; l++)
		{
			for(int i = 0 ; i <= arr.length -l;i++)
			{
				int j = i+l-1;
				if(mat[i+1][j].second + arr[i] > mat[i][j-1].second + arr[j])
				{
					mat[i][j] = new Element(mat[i+1][j].second + arr[i] , mat[i+1][j].first);
				}
				else
				{
					mat[i][j] = new Element(mat[i][j-1].second + arr[j], mat[i][j-1].first);
				}
			}
		}
		return mat[0][mat[0].length-1].first;
	}
	
	public boolean wordSplit(String s,List<String> dic)
	{
		boolean[][] mat = new boolean[s.length()][s.length()];
		
		for(int i = 0; i < s.length(); i++)
		{	
			String stemp = s.substring(i,i+1);
			if(dic.contains((stemp)))
				mat[i][i] = true;
		}
		for(int l = 2;  l <= mat.length; l++)
		{
			for(int i = 0 ; i <= mat.length -l; i++)
			{
				int j = i+l-1;
				mat[i][j] = dic.contains(s.substring(i, j+1));
				if(!mat[i][j])
				{
					for(int k = i ; k < j ; k++)
					{
						mat[i][j] = mat[i][k] && mat[k+1][j];
						if(mat[i][j]) break;
					}
				}
			}
		}
		return mat[0][mat[0].length-1];
	}
	
	public boolean stringInterleaving(String s1, String s2, String s)
	{
		if(s.length() != s1.length() + s2.length()) return false;
		boolean[][] map = new boolean[s1.length()+1][s2.length()+1];
		
		map[0][0] = true;
		for(int i = 1; i < map[0].length; i++)
			if(s.charAt(i-1) == s2.charAt(i-1)) map[0][i] =  map[0][i-1];
			else
				map[0][i] = false;
		
		for(int i =1; i < map.length; i++)
			if(s.charAt(i-1) == s1.charAt(i-1)) map[i][0] =  map[i-1][0];
			else
				map[i][0] = false;
		
 		for(int i = 1; i < map.length; i ++)
		{
			for(int j = i, k = 1; k < map[0].length ; j++,k++)
			{
				if(s1.charAt(i-1) == s.charAt(j))
					map[i][k] = map[i-1][k];
				else if(s2.charAt(k-1) == s.charAt(j))
					map[i][k] = map[i][k-1];
				else
					map[i][k]= false;
			}
		}
		return map[map.length-1][map[0].length-1];
	}
	
	public int carAssembly(int[][] assembly, int[][] transfer, int[] entry, int[] exit)
	{
		int len = assembly.length;
		int[][] table = new int[len][assembly[0].length];
		table[0][0] = entry[0] + assembly[0][0];
		table[1][0] = entry[1] + assembly[1][0];
		for(int i = 1; i < table[0].length;i++)
		{
			table[0][i]= Math.min( table[0][i-1] + assembly[0][i], table[1][i-1] +transfer[1][i] + assembly[1][i]);
			table[1][i] = Math.min(assembly[1][i] + table[1][i-1], table[0][i-1] +transfer[0][i] + assembly[0][i]);
		}
		return Math.min(table[0][table[0].length- 1], table[1][table[1].length- 1]);
	}
	
	class Job implements Comparable<Job>
	{
		int start;
		int end;
		int profit;
		Job(int s, int e, int p)
		{
			this.start = s;
			this.end = e;
			this.profit = p;
		}
		
		public int compareTo(Job j)
		{
			return this.end - j.end;
		}
	}
	
	public int bestJobScheduling(int[] start,int[] end, int[] profit)
	{
		Job[] jobs = new Job[start.length];
		for(int i =0; i < start.length ; i++)
			jobs[i] = new Job(start[i],end[i],profit[i]);
		Arrays.sort(jobs);
		int[] maxprofit = new int[jobs.length];
		for(int i=0; i < maxprofit.length; i++)
			maxprofit[i] = jobs[i].profit;
		int max = Integer.MIN_VALUE;
		for(int i=1; i < maxprofit.length; i++)
		{
			for(int j = 0; j< i ; j++)
			{
				if(jobs[j].start < jobs[i].end)continue;
				maxprofit[i] = Math.max(maxprofit[j]+jobs[i].profit,maxprofit[i]);
			}
			max = Math.max(max, maxprofit[i]);
		}
		return max;
	}
	
	public int lenghtLongestArithmeticProgression(int[] arr)
	{
		int[][] mat = new int[arr.length][arr.length];
		int llap = 2;
		for(int i = 0; i < mat.length; i++)
			mat[i][mat[0].length -1] = 2;
		
		for(int j = mat[0].length-2 ; j > 1; j--)
		{
			int i = j-1;
			int k = j+1;
			for(; i>=0 &&k <= mat[0].length-1; )
			{
				int sum = arr[i] + arr[k]; 
				if(sum < 2*arr[j])k++;
				else if(sum > 2*arr[j]) i--;
				else
				{
					mat[i][j] = mat[j][k] + 1;
					llap = Math.max(llap, mat[i][j]);
					i--;
					k++;
				}
			}
		}
		return llap;
	}
	
	public int longestPalindromicSubstring(String s)
	{
		return 0;
	}
}