package LeetCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import LinkedLists.LinkedListNode;
import Tree.TreeNode;

public class ParseExpressionTree {

	class Node{
		public Node(String string) {
			this.val = string;
		}
		String val = "";
		Node right;
		Node left;
	}
	
	Node root;
	
	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		*/
		String[] sarr = new String[]{"(AB)C((DE)F)/R","(AB)C((DE)F)/RS","(AB)C((DE)F)/RSR","(AB)C((DE)F)/S","(AB)C((DE)F)/SR","(AB)C((DE)F)/SRS"};
		for(String s : sarr)
		{
			System.out.println(s);
			s = s.replaceAll("\\s+", "");
			
			String[] arr = s.split("/");
			
			ParseExpressionTree tree = new ParseExpressionTree();
			tree.root = tree.buildTree(arr[0]);
			arr[1] = arr[1].replaceAll("RR", "");
			arr[1] = arr[1].replaceAll("S+", "S");
			for(char c : arr[1].toCharArray())
			{
				switch (c)
				{
					case 'R':{
					tree.root = tree.mirror(tree.root);break;
					}
					case 'S':{
						tree.root = tree.simplify(tree.root);break;
					}
				}
			}
			System.out.println(tree.parseTree(tree.root));
		}
	}
	
	private Node buildTree(String exp)
	{
		Stack<Node> stack = new Stack<>();
		char[] carr = exp.toCharArray();
		Node t, t1, t2;
		for(int i = 0; i < exp.length();i++)
		{
			if(carr[i] == '(')
			{
				stack.push(new Node("()"));
			}
			else if(carr[i] == ')')
			{
				Node right= stack.pop();
				Node left = stack.pop();
				Node root = stack.pop();
				root.left = left;
				root.right = right;
				stack.push(root);
			}
			else
			{
				stack.push(new Node(""+carr[i]));
			}
		}
		t2 = stack.pop();
		t = stack.pop();
		t1 = stack.pop();
		t.right = t2;
		t.left = t1;
		return t;
	}
	
	private Node mirror(Node n)
	{
		if(n == null) return null;
		Node temp = n.left;
		n.left = mirror(n.right);
		n.right = mirror(temp);
		n.val = reverse(n.val);
		return n;
	}
	
	private Node simplifyRecursively(Node root)
	{
		if(root == null) return null;
		else
		{	
			Node left = simplifyRecursively(root.left);
			Node right = simplifyRecursively(root.right);
			if(root.val == "()")
			{
				root.val = left.val + right.val;
				root.left = null;
				root.right = null;
			}
			return root;
		}
	}
	
	private Node simplify(Node root)
	{
		Node left = root.left;
		Node right = root.right;
		root.left =  simplifyRecursively(left);
		right.left = simplifyRecursively(right.left);
		right.right = simplifyRecursively(right.right);
		return root;
	}
	
	private String parseTree(Node n)
	{
		if(n != null)
		{
			String left = parseTree(n.left);
			String right =  parseTree(n.right);
			if(n.val == "()")
			{
				return "(" + left + right+")";
			}
			else
			{
				return left + n.val +right ;
			}
		}
		else
			return "";
	}
	
	private String reverse(String s)
	{
		if(s == null || s.length() == 0 || s.length() == 1 || s.equals("()")) return s;
		return reverse(s.substring(1)) + s.charAt(0);
	}
}