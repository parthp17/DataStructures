package LinkedLists;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class LLImplementation {

	public static void pyramid(int height) {

		StringBuilder sLine = new StringBuilder();
		    for(int i=0; i<height ; i++) {
		    
		    
		        for(int j = 0; j < height -i ; j++)
		        {
		            sLine.append(" ");
		        }
		        
		       
		       int limit = 2*i+ 1;
		          
		          for(int k = 0 ; k < limit; k++)
		          {
		             sLine.append("x");
		          } 
		        System.out.println(sLine.toString());
		        sLine.delete(0,sLine.length());
		        String s;
		        
		    }

		}
	
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		LinkedListNode n1 = new LinkedListNode(0);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(3);
		LinkedListNode n5 = new LinkedListNode(4);
		LinkedListNode n6 = new LinkedListNode(5);
		LinkedListNode n7 = new LinkedListNode(6);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(null);
		ll.setHead(n1);
		ll.setLength(7);
		//ll.printLL();
		//System.out.println(ll.findMiddle().getData());
		//System.out.println(ll.isPalindrome());
		//ll.printLL();
		//System.out.println(ll.findLoop());
		//System.out.println(ll.getLength());
		//System.out.println(ll.findMiddle().getData());
		//ll.deleteLinkedList();
		//System.out.println(ll.getHead().getData() + ""+ll.getLength());
		//ll.reverse();
		//System.out.println(ll.getHead().getData() + ""+ll.getLength());
		//ll.printLL();
		//ll.reverseInPair();
		//ll.printLL();
		
		/*LinkedListNode node = LinkedList.recursiveReverse(ll.getHead());
		ll.setHead(node);
		ll.printLL();
		*/
		
		//ll.removeDuplicates();
		
		//ll.setHead(ll.reverseKNodesInGroupRecursively(ll.getHead(), 3));
		//ll.reverseKNodesInGroup(3);
		//ll.printLL();
		
		//LLImplementation.pyramid(4);
		
		//regexPassword("WNeQN@1edred");
		//l2brectangle(4);
		//countShops();
		printMaxInSlidingWindow(new int[]{12, 1, 78, 90, 57, 89, 56}, 3);
	}
	
	public static void regexPassword(String s)
	{
		String regex = "^(?=.*[A-Za-z0-9])(?=.*[$@$%*&])[A-Za-z0-9$@$%*&]+.{8,}$";
		//String regex = "^(?=.*[A-Za-z0-9])(?=.*\\d)(?=.*[$@$%*&])[A-Za-z\\d$@$%*&]+.{8,}$";
		if(s != null && s.length() >=1 && s.length() <= 1000 && s.matches(regex))
		{
			System.out.println("VALID");
		}
		else
		{
			System.out.println("INVALID");
		}
	}
	
	public static void l2brectangle(long n)
	{
		if(n < 1 || n > Math.pow(10, 12)) return;
		
		String s = "";
		for(long i = (long) Math.sqrt(n); i > 0; i--)
		{
			long l2 = (long) Math.pow(i, 2);
			if(n%l2==0)
			{
				//s.append(sum/l2);
				s+=n/l2 + " ";
				//s.append(" ");
			}
		}
		s = s.substring(0, s.length()-1);
		//s.deleteCharAt(s.length()-1);
		System.out.println(s.toString());
	}
//	************ ORIGINAL*****************
//	public static void countShops()
//	{
//		Scanner in = new Scanner(System.in);
//        String regexNumbers = "^[0-9 ]+";
//		String nq = in.nextLine();
//		if(!nq.matches(regexNumbers))return;
//		String f = in.nextLine();
//        if(!f.matches(regexNumbers))return;
//		String[] vals = nq.split(" ");
//		
//		int n = Integer.parseInt(vals[0]);
//		int q = Integer.parseInt(vals[1]);
//		if(n < 1 || n > Math.pow(10, 5) || q < 1 || q > Math.pow(10, 5)) return;
//		String[] fs = f.split(" ");
//		if(fs.length != n) return;
//		int[] fival = new int[n];
//		//int[] arr = new int[n];
//		//int[] numOfShops = new int[(int)Math.pow(10, 5)];
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		//java.util.Arrays.sort(fival);
//		TreeSet<Integer> set = new TreeSet<Integer>();
//		for(int j = 0; j < fs.length; j++)
//		{
//			if(Integer.parseInt(fs[j]) < 1 || Integer.parseInt(fs[j]) > Math.pow(10, 6)) return;
//			fival[j] = Integer.parseInt(fs[j]);
//			//arr[j] = fival[j];
//			Integer val;
//			
//			if( (val = map.get(fival[j])) != null)
//			{
//				map.put(fival[j], val + 1);
//			}
//			else
//			{
//				map.put(fival[j],1);
//			}
//			set.add(fival[j]);
//		}
//		
//		
//
//		String[] queries = new String[q];
//		for(int i = 0; i < q ; i++)
//		{
//			queries[i] = in.nextLine();
//			if(queries[i] == null || queries[i].isEmpty()) return;
//		}
//		
// 		for(String query : queries)
//		{
//			String[] change = query.split(" ");
//			if(change.length > 3) return;
//			if(change[0].equalsIgnoreCase("change"))
//			{ 
//				int i = Integer.parseInt(change[1]);
//				int fi = Integer.parseInt(change[2]);
//				if(i < 0 || i >= fival.length || fi < 1 || fi > Math.pow(10, 6)) return;
//				//fival[i] = fi;
//				int temp = fival[i];
//				Integer temp1 ;
//				if(  (temp1 = map.get(temp)) != null)
//				{
//					temp1--;
//					map.put(temp,temp1);
//				}
//				else
//				{
//					map.put(temp,0);
//				}
//				fival[i] = fi;
//				temp = fival[i];
//				if(  (temp1 = map.get(temp)) != null)
//				{
//					temp1++;
//					map.put(temp,temp1);
//				}
//				else
//				{
//					map.put(temp,1);
//					set.add(temp);
//				}
//			}
//			else if(change[0].equalsIgnoreCase("count"))
//			{
//				int numOFShops = 0;
//				/*for(int k : fival)
//				{
//					if(k >= Integer.parseInt(change[change.length-1])) numOFShops++; 
//				}*/
//				int sum = 0;
//				Set<Integer> set1 = set.tailSet(Integer.parseInt(change[change.length-1]), true);
//				Iterator<Integer> iset1 = set1.iterator();
//				while(iset1.hasNext())
//				{
//					Integer val1;
//					int value1 = iset1.next();
//					//System.out.println("value1" + value1  );
//					if((val1= map.get(value1)) != null)
//					{
//						sum += val1; 
//					}
//				}
//				System.out.println(sum);
//			}
//			else
//			{
//				return;
//			}
//		}
//	}
//	******************* Original Ends ******************
	
	public static void countShops()
	{
		Scanner in = new Scanner(System.in);
        String regexNumbers = "^[0-9 ]+";
		String nq = in.nextLine();
		if(!nq.matches(regexNumbers))return;
		String feeLine = in.nextLine();
        if(!feeLine.matches(regexNumbers))return;
		String[] values = nq.split(" ");
		
//		Map<Integer, Integer> feeMap = new HashMap<Integer, Integer>();
//		Map<Integer, Integer> shopMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
//		
		
		int shopNumber = Integer.parseInt(values[0]);
		int totalQueries = Integer.parseInt(values[1]);
		if(shopNumber < 1 || shopNumber > Math.pow(10, 5) || totalQueries < 1 || totalQueries > Math.pow(10, 5)) return;
		String[] fees = feeLine.split(" ");
		if(fees.length != shopNumber) return;
		int[] fival = new int[shopNumber];
		
		for(int j = 0; j < fees.length; j++)
		{
			if(Integer.parseInt(fees[j]) < 1 || Integer.parseInt(fees[j]) > Math.pow(10, 6)) return;
			fival[j] = Integer.parseInt(fees[j]);
			int feeInt = Integer.parseInt(fees[j]);
//			feeMap.put(j, feeInt);
//			if (!shopMap.containsKey(feeInt)) {
//				shopMap.put(feeInt, 1);
//			} else {
//				shopMap.put(feeInt, shopMap.get(feeInt) +1);
//			}
		}
		
//		int max = Collections.max(shopMap.keySet());
		createCountMap(countMap, fival);
		int max = Collections.max(countMap.keySet());
		
		String[] queries = new String[totalQueries];
		for(int i = 0; i < totalQueries ; i++)
		{
			queries[i] = in.nextLine();
			if(queries[i] == null || queries[i].isEmpty()) return;
		}
		int numOFShops = 0;
		
 		for(String query : queries)
		{
			String[] change = query.split(" ");
			if(change.length > 3) return;
			if(change[0].equalsIgnoreCase("change"))
			{ 
				int i = Integer.parseInt(change[1]);
				int fi = Integer.parseInt(change[2]);
//				if(i < 0 || i >= fival.length || fi < 1 || fi > Math.pow(10, 6)) return;
				
				int origVal = fival[i];
				fival[i] = fi;
				updateCountMap(countMap, fi, i, fival, origVal);
//				change(shopMap, feeMap, countMap, i, fi, max);
			}
			else if(change[0].equalsIgnoreCase("count"))
			{
				int shop =0;
//				for(int k : fival)
//				{
//					if(k >= Integer.parseInt(change[change.length-1])) numOFShops++; 
//				}
				int value = Integer.parseInt(change[change.length-1]);
				shop = count(countMap, value, shop, max);
				System.out.println(shop);
			}
			else
			{
				return;
			}
		}	
	}
	
	private static void updateCountMap(Map<Integer, Integer> countMap, int fi, int i, int[] fiVal, int origVal) {
		
		countMap.put(origVal, countMap.get(origVal) - 1);
		if (!countMap.containsKey(fi)) {
			countMap.put(fi, 1);
		} else {
			countMap.put(fi, countMap.get(fi) + 1);
		}
		
		
	}

	private static void createCountMap(Map<Integer, Integer> countMap, int[] fiVal) {
		
//		Arrays.sort(fiVal);
		
		for (int i = 0; i < fiVal.length; i++) {
			if (countMap.containsKey(fiVal[i])) {
				countMap.put(fiVal[i], countMap.get(fiVal[i]) + 1);
			} else {
				countMap.put(fiVal[i], 1);
			}
		}
		
//		for (int m = max; m >= 0; m--) {
//			if (!countMap.containsKey(m + 1)) {
//				if (shopMap.containsKey(m)) {
//					countMap.put(m, shopMap.get(m));
//				} else {
//					countMap.put(m, 0);
//				}
//			} else {
//				if (shopMap.containsKey(m)) {
//					countMap.put(m, countMap.get(m + 1) + shopMap.get(m));
//				} else {
//					countMap.put(m, countMap.get(m + 1));
//				}
//			}
//		}
		
	}

//	public static void change (Map<Integer, Integer> shopMap, Map<Integer, Integer> feeMap, Map<Integer, Integer> countMap, int index, int update, int max) {
//		
//		int currentVal = feeMap.get(index);
//		feeMap.put(index, update);
//		
//		shopMap.put(currentVal, shopMap.get(currentVal) - 1);
//		if (shopMap.containsKey(update)) {
//			shopMap.put(update, shopMap.get(update) + 1);
//		} else {
//			shopMap.put(update, 1);
//		}
//		updateCountMap(max, countMap, shopMap);
//		
//	}
	
	public static int count ( Map<Integer, Integer> countMap, int fee, int shop, int max) {
//		int value =0;
		if (fee < max) {
			if (countMap.containsKey(fee)) {
				shop = countMap.get(fee);
				return count(countMap, fee+1, shop, max);
			}
			else {
				return count(countMap, fee+1, shop, max);
			} 
			
		} else if (fee == max) {
			shop += countMap.get(max);
			return shop;
		}
		return shop;
	}
	
	public static void printMaxInSlidingWindow(int[] arr, int k)
	{
		Deque<Integer> dq = new java.util.LinkedList();
		int i = 0;
		for(; i < k ; i++)
		{
			while( !dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
			{
				dq.pollLast();
			}
			
			dq.addLast(i);
		}
		for(; i < arr.length ; i++)
		{
			System.out.println(arr[dq.peekFirst()]);
			//System.out.println(arr[dq.peekFirst()]);
			while( !dq.isEmpty() && (i - k) >= dq.peekFirst())
			{
				dq.pollFirst();
			}
			while( !dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
			{
				dq.pollLast();
			}
			dq.addLast(i);
		}
		System.out.println(arr[dq.peekFirst()]);
		
		
	}

}