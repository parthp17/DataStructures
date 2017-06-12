package Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
public class Trie {
	private TrieNode root;
	private class TrieNode{
		
		Map<Character,TrieNode> map;
		LinkedList<Integer> ls;
		boolean isEnd = false;
		public TrieNode()
		{
			map = new HashMap<Character,TrieNode>();
		}
	}
	public Trie()
	{
		this.root = new TrieNode();
	}
	public TrieNode getRoot() {
		return root;
	}
	public void setRoot(TrieNode root) {
		this.root = root;
	}
	
	public void insert(String word, int index)
	{
		if(word == null )return;
		TrieNode currentNode = this.getRoot();
		for(int i = 0 ; i < word.length(); i++)
		{
			char c = word.charAt(i);
			TrieNode temp = currentNode.map.get(c);
			if(temp == null)
			{
				temp = new TrieNode();
				currentNode.map.put(c, temp);
				
			}
			currentNode = temp;
		}
		if(currentNode.map.get('\0') == null)
		{
			TrieNode temp = new TrieNode();
			currentNode.map.put('\0',temp);
			currentNode = temp;
			currentNode.isEnd = true;	
		}
		else
		{
			currentNode = currentNode.map.get('\0');
		}
		if(currentNode.ls == null)
		{
			currentNode.ls = new LinkedList<Integer>();
			currentNode.isEnd = true;
		}
		currentNode.ls.add(index);
	}
	
	public void printAnagramsTogether(String[] sArr)
	{
		
		ArrayList<String> ls = new ArrayList<String>();
		int i = 0;
		for(String s : sArr)
		{
			char [] c = s.toCharArray();
			java.util.Arrays.sort(c);
			ls.add(String.valueOf(c));
			this.insert(String.valueOf(c), i);
			i++;
		}
		printAnagramsTogether(this.root,sArr);
	}
	
	private void printAnagramsTogether(TrieNode node, String[] sArr)
	{
		if(node == null) return;
		
		if(node.map.get('\0') != null)
		{
			for(Integer i : node.map.get('\0').ls)
			{
				System.out.println(sArr[i]);
			}
		}
		for(Character c : node.map.keySet())
		{
			printAnagramsTogether(node.map.get(c),sArr);
		}
	}
}