package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomizedSet {

    /** Initialize your data structure here. */
	HashMap<Integer, Integer> map;
	List<Integer> ls ;
	java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
    	map = new HashMap<>();
    	ls = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
        	return false;
        }
        else
        {
        	map.put(val, ls.size());
        	return ls.add(val);
        }
        	
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val)) return  false;
    	else
    	{
    		int last = ls.get(ls.size() -1);
    		int index=map.get(val);
    		ls.set(index, last);
    		map.put(last, index);
    		map.remove(val);
    		ls.remove(ls.size()-1);
    		return true;
    	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	return ls.get(rand.nextInt(ls.size()));
    }
    
    public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		System.out.println(set.insert(3));
		System.out.println(set.insert(-2));
		System.out.println(set.remove(2));
		System.out.println(set.insert(1));
		System.out.println(set.insert(-3));
		System.out.println(set.insert(-2));
		
		System.out.println(set.remove(-2));
		System.out.println(set.remove(3));
		System.out.println(set.insert(-1));
		System.out.println(set.remove(-3));
		System.out.println(set.insert(1));
		System.out.println(set.insert(-2));
		System.out.println(set.insert(-2));
		System.out.println(set.insert(-2));
		System.out.println(set.insert(1));
		
		System.out.println(set.getRandom());
		System.out.println(set.insert(-2));
		System.out.println(set.remove(0));
		System.out.println(set.insert(-3));
		System.out.println(set.insert(1));
	}
}