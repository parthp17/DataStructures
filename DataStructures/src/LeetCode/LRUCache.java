package LeetCode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	
	class LRUCacheCDLLNode{
		int key;
		int value;
		LRUCacheCDLLNode next;
		LRUCacheCDLLNode prev;
		public LRUCacheCDLLNode(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}	
	}
	
	int capacity;
	Map<Integer,LRUCacheCDLLNode> map = new HashMap<>();
	LRUCacheCDLLNode head = null;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    private int reorganize(LRUCacheCDLLNode node)
    {
    	if(node.equals(this.head))
    	{
    		this.head = head.next;
    	}
    	else
    	{
    		node.prev.next = node.next;
        	node.next.prev = node.prev;
        	node.prev = head.prev;
        	node.next = head;
        	head.prev.next = node;
        	head.prev = node;
    	}
    	return node.value;
    }
    
    public int get(int key) {
    	
        if(map.containsKey(key))
        {
        	LRUCacheCDLLNode node =  map.get(key);
        	if(node.equals(head.prev)) return node.value;
        	return reorganize(node);
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	LRUCacheCDLLNode node;
    	if(map.containsKey(key))
        {
    		node = map.get(key);
        	node.value = value;
        	if(!node.equals(head.prev))
        	reorganize(node);
        }
        else
        {
        	node = new LRUCacheCDLLNode(key, value);
        	map.put(key, node);
        	if(map.size() > this.capacity)
        	{
        		node.next = head.next;
        		node.prev = head.prev;
        		head.prev.next = node;
        		head.next.prev = node;
        		head.next = null;
        		head.prev = null;
        		map.remove(this.head.key);
        		this.head = node.next;
        	}
        	else if(map.size() == 1)
        	{
        		node.next = node;
        		node.prev = node;
        		this.head = node;
        	}
        	else
        	{
        		node.next = head;
        		node.prev = head.prev;
        		head.prev.next = node;
        		head.prev = node;
        	}
        }
    }
    
    public static void main(String[] args) {
		
    	LRUCache cache = new LRUCache(4);
    	System.out.println(cache.get(0));
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.put(3, 3);
    	cache.put(4, 4);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(4));
    	cache.put(0, 0);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(4));
    	cache.put(5, 5);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    	System.out.println(cache.get(5));
    	
	}
    
    /*public class LRUCache {
        private LinkedHashMap<Integer, Integer> cache ;
        
        public LRUCache(int capacity) {
            cache = new LinkedHashMap<Integer, Integer>(capacity, 1f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }
        
        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }
        
        public void put(int key, int value) {
            cache.put(key, value);
        }
    }*/
}