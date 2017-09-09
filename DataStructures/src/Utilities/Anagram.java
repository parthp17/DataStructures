package Utilities;

import java.util.Arrays;

public class Anagram {
	
	static int[] getMinimumDifference(String[] a, String[] b) {
        int[] arr  = null;
        if(a != null && b != null)
        {
            int len = a.length > b.length ? b.length : a.length;
            arr = new int[len];
            Arrays.fill(arr,-1);
            for(int i = 0; i < len ; i++)
            {
                arr[i] = isAnagram(a[i],b[i]);
            }
        }
        return arr;
    }

    static int isAnagram(String s1, String s2){
    
        int diff =  0;
        if(s1 == null && s2 != null) return -1;
		else if(s2 == null && s1 != null) return -1;
		else if((s1 == null && s2 == null) || s1.equals(s2)) return 0;
		else if(s1.length() != s2.length()) return -1;
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
				if(i != 0) diff += Math.abs(i);			
			return (diff >> 1);
		}
        
    }

	
	public static void main(String[] args) {
		
		int[] arr = getMinimumDifference(new String[]{"hhpddlnnsjfoyxpci"},new String[]{"ioigvjqzfbpllssuj"});
		Arrays.stream(arr).forEach(System.out::println);
		
		
	}
}
