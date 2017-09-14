package LeetCode;

import java.io.*;
import java.util.*;


public class CountingNumberOfWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] in=br.readLine().split(" ");
            long N = Long.parseLong(in[0]);
            long K = Long.parseLong(in[1]);

            long out_ = solve(K, N);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static long solve(long K, long N){
        if(K < 1) return 0l;
        long[] arr = new long[(int)N+1];
        arr[0] = 1l;
        solve((int)K,(int)N,arr);
        return ((long)arr[(int)N]%((long) Math.pow(10, 9) + 7));
    }
    
    static long solve(int K, int N, long[] arr)
    {
    	if(N < 0) return 0;
        if(arr[N] != 0) return arr[N];
        for(long i = 1; i <= K;i++)
        {
            arr[(int)N] += solve((int)K, (int)(N-i), arr);
        }
        return arr[(int)N];
    }
}