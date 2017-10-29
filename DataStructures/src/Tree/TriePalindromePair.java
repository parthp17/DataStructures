package Tree;

import java.util.ArrayList;
import java.util.List;

public class TriePalindromePair {
	    
	    public List<List<Integer>> list;
	        
	    private class Trie{
	        Trie[] children;
	        List<Integer> psuffix;
	        int id;
	        boolean leaf;
	        
	        public Trie() {
	            leaf = false;
	            id = -1;
	            children = new Trie[26];
	            psuffix = new ArrayList<>();
	            
	            for(int i=0;i<26;i++)
	                children[i] = null;
	        }
	    }
	    
	    public void insert(Trie root,String word,int id){
	        
	        Trie cur = root;
	        for(int i= word.length() - 1 ;i >= 0; i--){
	            
	            int index = word.charAt(i) - 'a';
	            if(cur.children[index] == null)
	                cur.children[index] = new Trie();
	            
	            if(isPalindrome(word,0,i)){
	                (cur.psuffix).add(id);
	            }
	            
	            cur = cur.children[index];
	        }
	        
	        cur.id = id;
	        (cur.psuffix).add(id);
	        cur.leaf = true;
	    }
	    
	    public void search(Trie root,String word,int id){
	        
	        Trie cur = root;
	        for(int i = 0;i< word.length();i++){
	            
	            int index = word.charAt(i) - 'a';
	            if(cur.id >= 0 && cur.id != id && isPalindrome(word,i,word.length()-1)){
	                
	                List<Integer> tmp = new ArrayList<>();
	                tmp.add(id);
	                tmp.add(cur.id);
	                list.add(tmp);
	            }
	            
	            if (cur.children[index] == null)
	                return;
	            
	            cur = cur.children[index];
	        }
	        
	        for(int i=0;i<(cur.psuffix).size();i++){
	                if(cur.psuffix.get(i) == id)
	                    continue;
	                
	                List<Integer> tmp = new ArrayList<>();
	                tmp.add(id);
	                tmp.add(cur.psuffix.get(i));
	                list.add(tmp);
	        }
	    }
	    
	    public boolean isPalindrome(String word,int s,int e){
	        
	        while(s<e){
	            if(word.charAt(s) == word.charAt(e)){
	                s++;
	                e--;
	            }else
	                return false;
	        }
	        return true;
	    }
	    
	    public List<List<Integer>> palindromePairs(String[] words) {
	        Trie root = new Trie();
	        int len = words.length;
	        list = new ArrayList<>();
	        
	        for(int i=0;i<len;i++)
	            insert(root,words[i],i);
	        
	        for(int i=0;i<len;i++)
	            search(root,words[i],i);
	        
	        return list;
	    }
}
