package Arrays;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

	public static int degreeOfArray(int[] arr){
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> startPoint = new HashMap<>();
		Map<Integer, Integer> endPoint = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
		   int value = arr[i];
		   if(map.containsKey(value)){
		      map.put(value, map.get(value) + 1);
		   }else{
			   startPoint.put(value, i);
		      map.put(value, 1);
		   }
		   endPoint.put(value, i);
		   max = Integer.max(max, map.get(value));
		}
		int result = arr.length;
		for(int i : map.keySet()){
		   if(map.get(i) == max){
		      int len = endPoint.get(i) - startPoint.get(i) + 1;
		      result = Integer.min(result, len);
		   }
		}
		return result;
	}
	
	public static void main(String[] args) {		
		System.out.println(degreeOfArray(new int[]{1,2,3,4,2,2,3}));
	}
}
