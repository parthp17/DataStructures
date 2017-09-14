package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class NthMultiple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] in=br.readLine().split(" ");
            long a = Long.parseLong(in[0]);
            long b = Long.parseLong(in[1]);
            long n = Long.parseLong(in[2]);

            long out_ = solve(a, b, n);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    
    static long solve(long a, long b, long n){
        
    	int rows = (int)(n / 100000) + 1;
    	long[][] arr = new long[rows][(int)n%100000];
        
        long small = Math.min(a, b);
        arr[0][0] = small;
        long big = Math.max(a, b);
        long i1 = arr[0][0]/small + 1;
        long i2 = arr[0][0]/big + 1;
        long i1val, i2val;
        int row = 0;
        int col = 0;
        
        for(long i= 1; i < n ; i++)
        {
        	i1val = (i1 * small);
        	
        	i2val = (i2 * big);
        	while(i2val % small == 0)
        	{
        		i2++;
        		i2val = (i2 * big);
        	}
        	row =(int)i/100000;
        	col = (int)i%100000;
        	arr[row][col] = Math.min(i2val, i1val);
        	if(arr[row][col] == i2val) i2++;
        	else i1++;
        }
        return arr[rows-1][(int)n%100000-1];
    }
    
    

}

