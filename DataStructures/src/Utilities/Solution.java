package Utilities;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        char[] arr = number.toCharArray();
        int diff = 0;
        for(int i = 0 ; i< number.length()/2; i++)
         {
            if(number.charAt(i) != number.charAt(number.length() -i -1)) diff++; 
         }
        if(number.length() == 1) 
        	{
        		System.out.println(9);
        		return;
        	}
        
        if(diff > k) 
        	{
        		System.out.println("-1");
        	}
        else if (diff == k)
        {
          for(int i = 0 ; i< number.length()/2; i++)
          {
            if(number.charAt(i) > number.charAt(number.length() -i -1))
            {
                arr[arr.length - i -1] = arr[i];
            }
            else if(number.charAt(i) < number.charAt(number.length() -i -1))
            {
                 arr[i] = arr[arr.length - i -1];
            }
          }
            
            System.out.println(String.valueOf(arr));
        }
        else
        {
        	System.out.println("here");
           for(int i = 0 ; i < number.length()/2; i++)
          {
               if(k - diff > 1 && number.charAt(i) != '9' && number.charAt(number.length() -i -1) != '9')
               {
                   arr[i]='9';
                   arr[number.length() - i- 1] = '9';	
                   k = k-2;
               }
               else
               {
                   if(number.charAt(i) == number.charAt(number.length() -i -1)) continue;
                   else if (k > diff)
                       {
                       arr[i]='9';
                   arr[number.length() - i- 1] = '9';
                   k = k-2;
                       diff--;
                   }
                   else
                  {
                       k--;
                        diff--;
                       if(number.charAt(i) > number.charAt(number.length() -i -1))
                        {
                            arr[arr.length - i -1] = arr[i];
                        }
                        else if(number.charAt(i) < number.charAt(number.length() -i -1))
                        {
                            arr[i] = arr[arr.length - i -1];
                        }
                   }
               }
          }
            System.out.println(String.valueOf(arr));
        }
    }
}