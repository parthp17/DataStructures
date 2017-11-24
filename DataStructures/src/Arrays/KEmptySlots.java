package Arrays;

public class KEmptySlots {
	public static void main(String[] args) {
		
		KEmptySlots k = new KEmptySlots();
		
		System.out.println(k.kEmptySlots(new int[]{2,4,3,1,5}, 2));
	}
	
	public int kEmptySlots(int[] flowers, int k) {
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        //if(days[k] == 1 || days[days.length - k - 1] == 1) return 1;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i; 
                right = k + 1 + i;
            }
        }
        int  i = 1;
        boolean flag  = true;
        for( ; i <= k && flag; i++)
        {
        	if(days[i] < days[i-1]) continue;
        	else flag = false; 
        }
        if(flag && days[k] < res ) res = days[k];
        flag = true;
        i = days.length -2;
        for( ; i >= days.length - k -1 && flag; i--)
        {
        	if(days[i] < days[i+1]) continue;
        	else flag = false; 
        }
        if(flag && days[days.length - k -1] < res ) res = days[days.length - k -1];
        
        /*for(int i )
        if(days[k] < res) 
        	return days[k];
        else if((days[days.length - k - 1] < res))
        	 return days[days.length - k - 1];
        */	 
        return (res == Integer.MAX_VALUE)?-1:res;
    }
}
