package Utilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.omg.Messaging.SyncScopeHelper;

import java.math.*;

public class StringUtility {

	public static boolean isPalindrome(String s)
	{
		if(s == null || s.length() == 0 || s.length() == 1) return true;
		return (s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1)));
	}
	
	public static String reverseString(String s)
	{
		if(s == null || s.length() == 0 || s.length() == 1) return s;
		return (reverseString(s.substring(1)) + s.charAt(0));
	}
	
	public static int maxTime(int a, int b, int c, int d)
	{
		String str = "" + a + b + c + d;
		char[] time = str.toCharArray(); 
		Arrays.sort(time);
		str = String.copyValueOf(time);
			Set<String> set = new TreeSet<String>();
			generatePermutations("",str,set);
			int maxTime = 0;
			for(String s : set)
			{
				if(s.matches("([01][0-9]|2[0-3])[0-5][0-9]") && maxTime < Integer.parseInt(s))
				{
					maxTime = Integer.parseInt(s);
					continue;
				}
				if(Integer.parseInt(s) > 2359)
					break;
				
			}
			return maxTime;
			
	}
	
	private static void generatePermutations(String output, String remainder, Set<String> set)
	{
		
		int length = remainder.length();
		if(length == 0) set.add(output);
		for(int i = 0; i < length; i++)
		{
			String before= remainder.substring(0, i);
			String after = remainder.substring(i+1, length);
			char c = remainder.charAt(i);
			generatePermutations(output+c, before+after, set);		
		}
	}
	
	public static String nextLargestPalindrome(int number)
	{
		/*
		 * 
		 * calculate length
		 * check if its already a palindrome or reach to part which is not same on either side of mid 
		 * copy no matching left part to right part
		 * if leftpart < right part or number was plaindrome
		 * add 1 to mid and propogate carry to left and copy left to right
		 * 
		 * */
		String sNumber = String.valueOf(number);
		String sPalindrome = "";
		char[] arr = sNumber.toCharArray();
		int mid = sNumber.length()/2;
		int i = mid -1;
		int j = (sNumber.length()%2 == 1)?(mid+1):(mid);
		boolean leftSmaller = false;
		while(i >= 0 && arr[i] == arr[j])
		{
			i--;
			j++;
		}
		
		if(i < 0 || arr[i] < arr[j])
		leftSmaller = true;
		
		while(i >= 0)
		{
			arr[j] = arr[i];
			j++;
			i--;
		}
		
		if(leftSmaller)
		{
			int carry = 1;
			i = mid - 1;
			if(sNumber.length()%2 == 1)
			{
				arr[mid] += carry;
				carry = (Integer.parseInt(String.valueOf(arr[mid])))/10;
				arr[mid] = (char)((Integer.parseInt(String.valueOf(arr[mid])))%10 + 48);
				j = mid+1;
			}
			else
			{
				j = mid;
			}
			
			while(i >= 0)
			{
				int temp1 = arr[i];
				arr[i] += carry;				
				int temp = (Integer.parseInt(String.valueOf(arr[i])));
				carry = temp/10;
				temp%=10;
				arr[i] = (char)(temp+ 48);
				arr[j++] = arr[i--];
			}
		}
		return String.valueOf(arr);
	}
	
public static String findMaxTime(int a, int b, int c1, int d) {
		
		String s = ""+a+b+c1+d;
		char[] carray = s.toCharArray();
		java.util.Arrays.sort(carray);
		if( carray.length  > 4 || !(Integer.parseInt(String.valueOf(carray))/100 < 24 && Integer.parseInt(String.valueOf(carray))%100 < 60))
		return "NOT POSSIBLE";
		StringBuffer output = new StringBuffer();
		if(s.indexOf('2') > -1)
		{			
			s = s.substring(0,s.indexOf('2')) + s.substring(s.indexOf('2') +1, s.length());
			output.append('2');
			System.out.println(s);
			for(int i = 3; i >= 0; i--)
			{
				if(s.indexOf(String.valueOf(i)) < 0) continue;
				s = s.substring(0,s.indexOf(String.valueOf(i))) + s.substring(s.indexOf(String.valueOf(i)) +1, s.length());
				System.out.println(s);
				output.append(i);
				break;
			}
			System.out.println(output.toString());
		}
		else
		{
			if(s.indexOf('1') > -1)
			{
				s = s.substring(0,s.indexOf('1')) + s.substring(s.indexOf('1') +1, s.length());
				output.append('1');
			}
			else
			{
				s = s.substring(0,s.indexOf('0')) + s.substring(s.indexOf('0') +1, s.length());
				output.append('0');
			}

			char c = carray[carray.length - 1];
			output.append(c);
			if(s.indexOf(c) > -1)
				s = s.substring(0,s.indexOf(c)) + s.substring(s.indexOf(c) +1, s.length());
		}

		output.append(":");
		for(int i = 5; i >= 0; i--)
		{
			if(s.indexOf(String.valueOf(i)) < 0) continue;
				
			s = s.substring(0,s.indexOf(String.valueOf(i))) + s.substring(s.indexOf(String.valueOf(i)) +1, s.length());
			System.out.println(s);
			output.append(i);
			break;
		}
		output.append(s);
		return output.toString();
	}

	public static String removeDups(String s)
	{
		if(s == null) return null;
		HashSet<Character> set = new HashSet<Character>();
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < s.length(); i++)
		{
			if(set.add(s.charAt(i)))
			{
				str.append(s.charAt(i));
			}
		}
		return str.toString(); 
	}
	
	public static String removeDupsEfficient(String s)
	{
		if(s == null) return null;
		int length = s.length();
		int[] arr = new int[8];
		int index = 0;
		int bit = 0;
		StringBuilder str = new StringBuilder();
		for(int i =0; i < length; i++)
		{
			index = s.charAt(i) - '\0';
			bit = index%32;
			index /= 32;
			if((arr[index-1] & (1 << bit)) > 0)
				continue;
			else
			{
				arr[index-1] |= (1 << bit);
				str.append(s.charAt(i));
			}
		}
		return str.toString();
	}
	
	public static void printDuplicate(String s)
	{
		
		if(s==null) return;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i < s.length(); i++)
		{
			
			if(map.containsKey(s.charAt(i)))
			{
				int value = map.get(s.charAt(i));
				map.put(s.charAt(i), ++value);
			}
			else
			{
				map.put(s.charAt(i), 1);
				continue;
			}
		}
		for(Character c : map.keySet())
		{
			if(map.get(c) > 1)
				System.out.println(c);
		}
	}
	
	public static boolean hasDuplicates(String s)
	{
		if(s == null) return false;
		
		int[] arr = new int[4];
		int index = 0;
		for(int i = 0; i < s.length(); i++)
		{
			index = s.charAt(i) - '\0';
			int bit = index%32;
			index = index%4;
			if((arr[index] & (1 << bit)) > 0) return false;
			else
			{
				arr[index] |= 1 << bit;
			}
		}
		return true;
	}
	
	public static String removeDirtyChar(String s, String dirty)
	{
		if(s == null) return null;
		if(dirty == null || dirty.equals("")) return s;
		int[] arr = new int[8];
		int bit= 0;
		int index = 0;
		for(int i = 0; i < dirty.length(); i++)
		{
			index = dirty.charAt(i) - '\0';
			bit = index%32;
			index %= 8;
			arr[index] |= (1<<bit);
		}
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < s.length(); i ++)
		{
			index = s.charAt(i) - '\0';
			bit = index%32;
			index %= 8;
			System.out.println(arr[index] & (1 << bit));
			if((arr[index] & (1 << bit)) > 0)
				continue;
			else
				str.append(s.charAt(i));
		}
		return str.toString();
	}
	
	
	
	public static String reverseLine(String s)
	{
		if(s == null)return s;
		
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String str : arr)
		{
			sb.append(reverseString(str));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return reverseString(sb.toString());
	}
	
	public static String inPlaceStringTransformation(String s)
	{
		int sLenRem = s.length();
		char[] cArr = s.toCharArray(); 
		int shift = 0;
		int lenfirst, k ;
		while(sLenRem > 0)
		{
			k = 0;
			
			while((Math.pow(3, k) + 1) <= sLenRem) k++;
			
			lenfirst = (int)Math.pow(3, k-1) + 1;
			sLenRem -= lenfirst;
			
			//if oldindex is odd ;newindex = oldindex/2 + len/2; 
			//else newindex = oldindex/2; 
			cycleLeader(cArr,shift, lenfirst);
			
			//Reverse the second half of first
			reverse(cArr,shift/2,shift-1);
			
			//reverse the first half of second.
			reverse(cArr, shift, shift + lenfirst/2 -1);
			
			//reverse the 2nd half of the first and first half of the second together.
			reverse(cArr,shift/2, shift+lenfirst/2-1);
			
			shift += lenfirst;
		}
		
		return String.valueOf(cArr);
	}
	
	private static void reverse(char[] cArr, int i, int j)
	{	
		while(i < j)
		{
			char c = cArr[i];
			cArr[i] = cArr[j];
			cArr[j] = c;
			i++;
			j--;
		}
	}

	public static void cycleLeader(char[] cArr, int shift, int len)
	{
		//if oldindex is odd ;newindex = oldindex/2 + len/2; 
		//else newindex = oldindex/2; 
		char c, ctemp;
		int j;
		for(int i = 1 ; i < len; i = i*3)
		{
			j = i;
			c = cArr[shift+j];
			do{
				if((j & 1) > 0)
					j = len/2 + j/2;
				else
					j = j/2;
				
				//swap
				ctemp = cArr[j+shift];
				cArr[j+shift] = c;
				c = ctemp;
			}while(j != i);	
		}
	}
	
	public static void printExcelColumn(int n)
	{
		char c = 'A';
		char temp = '\0';
		StringBuilder str= new StringBuilder();
		while(n>0)
		{
			int rem = n %26;
			if(rem == 0)
			{	
				str.append('Z');
				n = n/26 - 1;
			}
			else
			{
				str.append((char)(rem - 1 + c));
				n  = n/26;
			}
		}
		System.out.println(str.reverse().toString());
	}
	
	public static boolean matchPattern(String s, String pattern)
	{
		if(s.length() == 0 && pattern.length() ==0) return true;
		if(pattern.length() > 0 && pattern.charAt(0) != '*' && s.length() == 0) return false;
		
		if((pattern.length() > 0 && pattern.charAt(0) == '?') || ( pattern.length() > 0 && s.length() > 0 && pattern.charAt(0) == s.charAt(0)))
			return matchPattern(s.substring(1), pattern.substring(1));
		
		if(pattern.length() > 0 && pattern.charAt(0) == '*' && s.length() >= 0)
			return (matchPattern(s,pattern.substring(1)) || matchPattern(s.substring(1), pattern));
		
		return false;
	}
	
	public static void intervleavedStrings(String s1, String s2, String output, int m , int n)
	{
		if(s1.length() == 0 && s2.length() == 0) 
		{
			System.out.println(output);return;
		}
		
		if(m != 0)
		{
			output += s1.charAt(0);
			System.out.println(output);
			intervleavedStrings(s1.substring(1), s2, output, m-1, n);
			//m -=1;
		}
		
		if(n != 0)
		{
			output += s2.charAt(0);
			System.out.println(output);
			intervleavedStrings(s1, s2.substring(1), output, m , n-1);
			//n -=1;
		}
	}
	
	public static void lexographicalRank(String s)
	{
		int len = s.length();
		int rank = 1;
		int countright = 0;
		int mul = factorial(len);
		for(int i = 0; i < len; i++)
		{
			mul /= len - i;
			countright = countSmallerOnRight(s.substring(i+1), s.charAt(i));
			rank += countright*mul;
		}
		System.out.println(rank);
	}
	
	private static int factorial(int n)
	{
		if(n <= 1) return 1;
		else
		{
			return n*factorial(n-1);
		}
	}
	
	private static int countSmallerOnRight(String s, char c)
	{
		int count  = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) < c) count++;
		}
		return count;
	}
	
	public static boolean isAnagram(String s1, String s2)
	{
		if(s1 == null && s2 != null) return false;
		else if(s2 == null && s1 != null) return false;
		else if((s1 == null && s2 == null) || s1.equals(s2)) return true;
		else if(s1.length() != s2.length()) return false;
		else
		{
			int[] count = new int[256];
			for(char c: s1.toCharArray())
			{
				count[c-'\0']++;
			}
			for(char c : s2.toCharArray())
			{
				count[c-'\0']--;
			}
			for(int i : count)
				if(i != 0) return false;			
			return true;
		}
	}
	
	public static List<String> distinctPermutations(String s)
	{
		List<String> list = new ArrayList<String>();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(char c : s.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		int index = 0;
		char[] str = new char[map.size()];
		int[] count = new int[map.size()];
		for(char c : map.keySet())
		{
			str[index] = c;
			count[index] = map.get(c);
			index++;
		}
		char[] carr = new char[s.length()];
		distinctionPermutations(str,count,carr,0,list);
		list.forEach(s3 -> {System.out.println(s3);});
		return list;
	}

	private static void distinctionPermutations(char[] str, int[] count,char[] result, int level , List<String> list) 
	{		
		if(level == result.length) 
		{
			list.add(String.valueOf(result));
			return;
		}
		for(int i = 0 ; i < str.length ; i++)
		{
			if(count[i] == 0) continue;
			result[level] = str[i];
			count[i]--;
			distinctionPermutations(str, count, result, level+1, list);
			count[i]++;
		}
	}
	public static ArrayList<String> generatePermutations(String s)
	{
		ArrayList<String> ls = new ArrayList<String>();
		generatePermutations(s.toCharArray(), 0, s.length()-1,ls);
		ls.forEach(s1 -> {System.out.println(s1);});
		return ls;
	}
	
	public static void generatePermutations(char[] s, int start, int end, ArrayList<String> ls)
	{
		if(start==end)
		{
			ls.add(String.valueOf(s));
		}
		else
		{
			for(int i = start; i <= end; i++)
			{
				swap(s, start, i);
				generatePermutations(s, start + 1, end, ls);
				swap(s, start, i);
			}
		}
	}
	public static void swap(char[] s, int a , int b)
	{
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
	
	public static void printPrimeNumbers(int n)
	{
		boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		
		for(int i = 2 ; i*i < n; i++)
		{
			if(arr[i])
				for(int j = i*2 ; j < n; j = j+i)
					arr[j] = false;
		}
		for(int i = 1; i < arr.length ; i++)
		{
			if(arr[i])
				System.out.println(i);
		}
	}
}