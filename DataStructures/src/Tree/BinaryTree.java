package Tree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void visitNode(TreeNode n) {
		System.out.println(n.getValue());
	}

	public void preOrderTraversal(TreeNode n) {
		if (n != null) {
			visitNode(n);
			preOrderTraversal(n.getLeft());
			preOrderTraversal(n.getRight());
		}
		return;
	}
	
	public void preOrderTraversalIterative(TreeNode root)
	{
		if(root != null)
		{
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while(!stack.isEmpty())
			{
				TreeNode node = stack.pop();
				visitNode(node);
				if(node.getRight() != null) stack.push(node.getRight());
				if(node.getLeft() != null) stack.push(node.getLeft());
			}
		}
	}

	public void postOrderTraversal(TreeNode n) {
		if (n != null) {
			postOrderTraversal(n.getLeft());
			postOrderTraversal(n.getRight());
			visitNode(n);
		}
		return;

	}

	public void inOrderTraversal(TreeNode n) {
		if (n != null) {
			inOrderTraversal(n.getLeft());
			visitNode(n);
			inOrderTraversal(n.getRight());
		}
		return;

	}

	public int getHeight(TreeNode n) {
		if (n == null)
			return 0;
		return Math.max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1;
	}

	public void levelOrderTraversal(TreeNode n) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (n == null) {
			return;
		}
		
		q.offer(n);

		while (!q.isEmpty()) {
			TreeNode nTemp = q.poll();
			if (nTemp.getLeft() != null)
				q.offer(nTemp.getLeft());
			if (nTemp.getRight() != null)
				q.offer(nTemp.getRight());
			this.visitNode(nTemp);
		}
		// return container;
	}

	public ArrayList<ArrayList<TreeNode>> levelOrderStorage(TreeNode n) {

		ArrayList<ArrayList<TreeNode>> container = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> list;

		if (n == null) {
			return null;
		}
		list = new ArrayList<TreeNode>();
		list.add(n);

		while (list.size() > 0) {
			container.add(list);
			ArrayList<TreeNode> tempList = list;
			list = new ArrayList<TreeNode>();
			for (TreeNode nTemp : tempList) {
				if (nTemp.getLeft() != null) {
					list.add(nTemp.getLeft());
				}

				if (nTemp.getRight() != null) {
					list.add(nTemp.getRight());
				}
			}
		}

		for (ArrayList<TreeNode> ls : container) {
			StringBuffer str = new StringBuffer();
			for (TreeNode t : ls) {
				str.append(t.getValue());
				str.append(" ");
			}
			System.out.println(str);
		}
		return container;
	}

	public void levelOrderStorage(TreeNode n, int startLevel, ArrayList<ArrayList<TreeNode>> composedList) {
		if (n == null)
			return;
		// System.out.println(composedList.size());
		ArrayList<TreeNode> list;

		if (composedList.size() == startLevel) {
			list = new ArrayList<TreeNode>();
			composedList.add(list);
		} else {
			list = composedList.get(startLevel);
		}

		list.add(n);
		if (n.getLeft() != null)
			levelOrderStorage(n.getLeft(), startLevel + 1, composedList);
		if (n.getRight() != null)
			levelOrderStorage(n.getRight(), startLevel + 1, composedList);
	}

	/*
	 * balanced binary tree
	 */

	public boolean isBalanced(TreeNode n, int[] hieght) {
		if (n == null)
		{
			hieght[0] = 0;
			return true;
		}
		int[] lhieght = new int[1];
		int[] rhieght = new int[1];
		boolean l = isBalanced(n.getLeft(),lhieght);
		boolean r = isBalanced(n.getRight(), rhieght);
		if(l && r && Math.abs(lhieght[0] - rhieght[0]) < 2)
		{
			hieght[0] = Math.max(lhieght[0], rhieght[0]) +1;
			return true;
		}
		else
			return false;
	}

	public int checkHeight(TreeNode n) {
		if (n == null)
			return -1;

		int leftHeight = checkHeight(n.getLeft());
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(n.getRight());
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, leftHeight) + 1;
		}
	}
	
	public boolean isBST(TreeNode n)
	{
		if(n == null) return true;
		if((n.getLeft() != null && n.getValue() <= n.getLeft().getValue()) || (n.getRight() != null && n.getValue() > n.getRight().getValue()))
		return false;
		return isBST(n.getLeft()) && isBST(n.getRight());
	}
	
	public static void binaryToBST(TreeNode n)
	{
		List<Integer> list = new LinkedList<Integer>();
		inOrderStorage(n,list);
		Collections.sort(list);
		inOrderReplace(n,list,new int[1]);
	}
	
	private static void inOrderStorage(TreeNode n, List<Integer> list)
	{
		if(n == null) return;
		inOrderStorage(n.getLeft(), list);
		list.add(n.getValue());
		inOrderStorage(n.getRight(),list);
	}
	
	private static void inOrderReplace(TreeNode n, List<Integer> list, int[] index)
	{
		if(n == null) return;
		inOrderReplace(n.getLeft(),list,index);
		n.setValue(list.get(index[0]++));
		inOrderReplace(n.getRight(),list,index);
	}
	
	public static void rootToLeafSums(TreeNode n)
	{
		List<Integer> list = new ArrayList<Integer>();
		rootToLeafSums(n, list, 0);

		for(Integer i : list)
			System.out.println(i);
		
	}
	
	private static void rootToLeafSums(TreeNode n, List<Integer> list, int value)
	{
		if(n == null) return ;
		value += n.getValue();
		if(n.getLeft() == null && n.getRight() == null) 
		{
			list.add(value);
		}
		rootToLeafSums(n.getLeft(),list, value);
		rootToLeafSums(n.getRight(),list, value);
	}
	
	public static int maxSumPath(TreeNode n, int[] max)
	{
		if(n == null) return 0;
		
		int left = maxSumPath(n.getLeft(), max);
		int right = maxSumPath(n.getRight(), max);
		
		int current = Math.max(n.getValue(), Math.max(n.getValue() + left, n.getValue() + right));
		max[0] = Math.max(Math.max(current, n.getValue() + left + right), max[0]);
		
		return current;
		
		/*if(n == null) return 0;
		
		int left = maxSumFromRootToLeaf(n.getLeft(), max);
		int right = maxSumFromRootToLeaf(n.getRight(), max);
		
		int val = (left > right) ? left : right;
		int current = n.getValue() + val;
		
		max[0] = Math.max(max[0], current);
		
		return current;*/
	}
	
	
	
	public static int size(TreeNode n)
	{
		if(n == null)
			return 0;
		else
			return (size(n.getLeft()) + 1 + size(n.getRight()));
	}
	
	public static boolean hasSum(TreeNode n, int sum)
	{
		if(n == null) return false;
		
		sum -= n.getValue();
		if(n.getLeft() == null && n.getRight() == null && sum == 0)
		{
			return true;
		}
		return (hasSum(n.getLeft(), sum) || hasSum(n.getRight(), sum));
	}
	
	public static List<String> printPath(TreeNode n)
	{
		List<String> list= new ArrayList<String>(); 
		printPath(n,list, null);
		return list;
	}
	
	private static void printPath(TreeNode n, List<String> list, String spath)
	{
		if(n == null) return;
		
		if(spath == null) spath = "";
		spath += n.getValue() + "->";
		
		if(n.getLeft() == null && n.getRight() == null)
		{
			spath += "NULL";
			list.add(spath);
		}
		
		printPath(n.getLeft(), list, spath);
		printPath(n.getRight(), list, spath);
		
	}
	
	public static TreeNode mirror(TreeNode n)
	{
		if(n == null) return null;
		
		TreeNode temp = n.getLeft();
		n.setLeft(mirror(n.getRight()));
		n.setRight(mirror(temp));
		
		return n;
	}
	
	public static boolean sameTree(TreeNode n1, TreeNode n2)
	{
		if(n1 == null && n2 == null) return true;
		else if(n1 != null && n2 != null)
		{
			return (n1.getValue() == n2.getValue() && sameTree(n1.getLeft(),n2.getLeft()) && sameTree(n1.getRight(),n2.getRight()));
		}
		else
		{
			return false;
		}
	}
	
	public static boolean equalTrees(TreeNode n1, TreeNode n2)
	{
		if((n1 != null && n2 == null) || (n1 == null && n2 != null) )
			return false;
		if(n1 == null && n2 == null) return true;
		
		if(n1.getValue() != n2.getValue()) return false;
		else
		{
			return equalTrees(n1.getLeft(),n2.getLeft()) && equalTrees(n1.getRight(), n2.getRight());
		}
	}
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2)
	{
		if(root == null || root == n1 || root == n2) return root;
		TreeNode x = lowestCommonAncestor(root.getLeft(), n1, n2);
		if(x != null && x!=n1 && x != n2) 
			return x;
		TreeNode y = lowestCommonAncestor(root.getRight(), n1, n2);
		if(y != null && y !=n1 && y != n2) 
			return y;
		
		if(x != null && y != null)
			return root;//null
		else if (x != null && y != null) return root;
		else
			return x == null ? y:x;
	}
	
	public static TreeNode leastCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null) return null;
		if(covers(root,n1) && covers(root,n2))
		{
			return lowestCommonAncestor(root, n1, n2);
		}
		return null;
	}
	
	private static boolean covers(TreeNode root, TreeNode n)
	{
		if(root == null) return false;
		if(root == n) return true;
		
		return covers(root.getLeft(),n) || covers(root.getRight(),n);	
	}
	
	
	
	public static TreeNode treeToCircularDoubleLinkedList(TreeNode n1)
	{
		if(n1 == null) return null;
		
		TreeNode left = treeToCircularDoubleLinkedList(n1.getLeft());

		TreeNode right = treeToCircularDoubleLinkedList(n1.getRight());
		
		n1.setLeft(n1);
		n1.setRight(n1);
		
		return concatinateCDLL(concatinateCDLL(left, n1),right);
	}
	
	private static TreeNode concatinateCDLL(TreeNode left, TreeNode right)
	{
		if(left == null) return right;
		if(right == null) return left;
		
		TreeNode leftLast = left.getLeft();
		TreeNode rightLast = right.getLeft();
		
		leftLast.setRight(right);
		right.setLeft(leftLast);
		
		left.setLeft(rightLast);
		rightLast.setRight(left);
		
		return left;
	}
	
	public static int getLeafCount(TreeNode n)
	{
		if(n == null) return 0;
		
		if(n.getLeft() == null && n.getRight() == null)
		{
			return 1;
		}
		
		return getLeafCount(n.getLeft()) + getLeafCount(n.getRight());
	}
	
	public static void printLevelOrderZigZag(TreeNode n)
	{
		if(n != null)
		{
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			
			s1.push(n);
			Stack<TreeNode> s = s1;
			Stack<TreeNode> stemp;
			while(!s.isEmpty())
			{
				TreeNode n1 = s.pop();
				if(s == s1) 
				{
					stemp = s2;
					if(n1.getLeft() != null)
					stemp.push(n1.getLeft());
					if(n1.getRight() != null)
					stemp.push(n1.getRight());
				}
				else
				{
					stemp = s1;
					if(n1.getRight() != null)
					stemp.push(n1.getRight());
					if(n1.getLeft() != null)
					stemp.push(n1.getLeft());
				}
				System.out.println(n1.getValue());
				if(s.isEmpty())
				{
					s=stemp;
				}
			}
		}
		else
		{
			System.out.println("NULL");
		}
	}
	
	public static boolean parentEqualTosumOfChildrens(TreeNode n)
	{
		if(n == null) return true;
		if(n.getLeft() == null && n.getRight() == null) return true;
		
		if(parentEqualTosumOfChildrens(n.getLeft()) && parentEqualTosumOfChildrens(n.getRight()))
		{
			int left;
			int right;
			if(n.getLeft() == null) left = 0;
			else left = n.getLeft().getValue();
			if(n.getRight() == null) right = 0;
			else right = n.getRight().getValue();
			
			return n.getValue() == right+left;
		}
		return false;
	}
	
	public static TreeNode convertToChildSumTree(TreeNode n)
	{
		if(n == null || (n.getLeft() == null && n.getRight() == null)) return n;
		
		TreeNode left = convertToChildSumTree(n.getLeft());
		TreeNode right = convertToChildSumTree(n.getRight());
		
		int leftValue, rightValue, nodeValue  = n.getValue();
		
		if(left == null) leftValue = 0; 
		else leftValue = left.getValue();
		
		if(right == null) rightValue = 0;
		else rightValue = right.getValue();
		
		int diff = nodeValue - (leftValue + rightValue);
		if(diff == 0 );
		else if(diff < 0)
		{
			n.setValue(n.getValue() + Math.abs(diff));
			
		}
		else
		{
			left.setValue(leftValue + Math.abs(diff));
			convertToChildSumTree(left);
		}
		return n;
	}
	
	
	public static int getDiameter(TreeNode n, int[] maxHeight)
	{
		if(n == null) return 0;
		
		int leftHeight = getDiameter(n.getLeft(),maxHeight);
		int rightHeight = getDiameter(n.getRight(),maxHeight);
		
		if(maxHeight[0] < (leftHeight + rightHeight + 1))
		{
			maxHeight[0] = leftHeight+rightHeight+1;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static void inOrderWithStack(TreeNode n)
	{
		if(n == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(n != null)
		{
			stack.push(n);
			n = n.getLeft();
		}
		
		while(!stack.isEmpty())
		{
			n = stack.pop();
			System.out.println(n.getValue());
			if(n.getRight() != null)
			{
				n = n.getRight();
				while(n != null)
				{
					stack.push(n);
					n = n.getLeft();
				}
			}
		}
	}
	
	
	public static void inOrderIterative(TreeNode n)
	{
		if(n == null) return;
		
		TreeNode current, pre;
		
		current = n;
		
		while(current != null)
		{
			if(current.getLeft() == null)
			{
				System.out.println(current.getValue());
				current = current.getRight();
			}
			else
			{
				pre =current.getLeft();
				
				while(pre.getRight() != null && pre.getRight() != current)
				{
					pre = pre.getRight();
				}
				
				if(pre.getRight() == null)
				{
					pre.setRight(current);
					current = current.getLeft();
				}
				else
				{
					pre.setRight(null);
					System.out.println(current.getValue());
					current = current.getRight();
				}
			}
		}
	}
	
	
	public static TreeNode buildTree(int[] pre, int[] in,int inStart,int inEnd, int[] preIndex)
	{
		if(inStart > inEnd) return null;
		TreeNode n = new TreeNode(pre[preIndex[0]]);
		preIndex[0]++;
		int inIndex = getInIndex(in, n.getValue());
		n.setLeft(buildTree(pre, in, 0, inIndex -1, preIndex));
		n.setRight(buildTree(pre, in, inIndex+1, inEnd, preIndex));
		
		return n;
	}
	
	public static int getInIndex(int[] in, int val)
	{
		for(int i = 0; i < in.length; i++)
			if(in[i] == val) return i;
		
		return -1;
	}
	
	public static TreeNode doubleTree(TreeNode n)
	{
		if(n == null) return n;
		
		TreeNode left = n.getLeft();
		TreeNode right  = n.getRight();
		TreeNode newNode = new TreeNode(n.getValue());
		n.setLeft(newNode);
		newNode.setLeft(left);
		doubleTree(left);
		doubleTree(right);
		
		return n;
	}
	
	public static int getWidth(TreeNode n)
	{
		if(n == null) return 0;
		
		ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
		ls.add(n);
		ArrayList<TreeNode> ls1;
		int width = 0;
		while(!ls.isEmpty())
		{
			ls1 = new ArrayList<TreeNode>();
			width = width > ls.size()?width:ls.size();
			for(TreeNode n1 : ls)
			{
				if(n1.getLeft() != null)
				ls1.add(n1.getLeft());
				if(n1.getRight() != null)
				ls1.add(n1.getRight());
			}
			ls = ls1;
		}
		return width;
	}
	
	public static boolean foldable(TreeNode n)
	{
		if(n == null) return true;
		TreeNode left = n.getLeft();
		TreeNode right = n.getRight();
		if((left == null && right == null) || (left != null && right != null))
		{
			return foldable(left) && foldable(right);
		}
		return false;
	}
	
	public static boolean printAncestor(TreeNode root, int val)
	{
		if(root == null) return false;
		if(root.getValue() == val) return true;
		if(printAncestor(root.getLeft(),val) || printAncestor(root.getRight(), val))
		{
			System.out.println(root.getValue());
			return true;
		}
		return false;
		
	}
	
	public static void printAncestor(TreeNode n, TreeNode n1)
	{
		if(n == null) return;
		if(n.getValue() == n1.getValue())
		return;
		
		ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
		ArrayList<TreeNode> ls1;
		ls.add(n);
		boolean isFound = false;
		while(!ls.isEmpty())
		{
			ls1 = new ArrayList<TreeNode>();
			for(TreeNode n2 : ls)
			{
				System.out.println(n2.getValue());
				if(n2.getLeft() != null && n2.getLeft().getValue() == n1.getValue())
				{
					isFound = true;
				}
				else if (n2.getLeft() == null);
				else
				{
					ls1.add(n2.getLeft());
				}
				
				if(n2.getRight() != null && n2.getRight().getValue() == n1.getValue())
				{
					isFound = true;
				}
				else if (n2.getRight() == null);
				else
				{
					ls1.add(n2.getRight());
				}
			}
			if(isFound) break;
			
			ls = ls1;
		}
	}
	
	public static boolean isSumTree(TreeNode n)
	{
		if(n == null) return true;
		TreeNode leftNode = n.getLeft();
		TreeNode rightNode = n.getRight();
		if(leftNode == null && rightNode == null) return true;
		
		if(leftNode != null && leftNode.getLeft() == null && leftNode.getRight() == null 
				&& rightNode !=null && rightNode.getLeft() == null && rightNode.getRight() == null 
					&& leftNode.getValue() + rightNode.getValue() == n.getValue())
		return true;
		
		if(leftNode.getValue() + rightNode.getValue() == n.getValue()/2)
		{
			return isSumTree(leftNode) && isSumTree(rightNode);
		}
		else
		{
			return false;
		}
	}
	
	public static void connectNodes(TreeNode n)
	{
		if(n == null) return;
		ArrayList<List<TreeNode>> storage = new ArrayList<List<TreeNode>>(); 
		List<TreeNode> ls = new ArrayList<TreeNode>();
		List<TreeNode> ls1;
		ls.add(n);
		
		while(!ls.isEmpty())
		{
			ls1 = new ArrayList<TreeNode>();
			for(int i = 0 ; i < ls.size(); i++)
			{
				TreeNode node = ls.get(i);
				TreeNode left = node.getLeft();
				TreeNode right = node.getRight();
				
				if(left != null)
					ls1.add(left);
				if(right != null)
					ls1.add(right);
				
				if(i<ls.size()-1) node.setRight(ls.get(i+1));
				else node.setRight(null);
				
				if(i>0)node.setLeft(ls.get(i-1));
				else node.setLeft(null);
			}
			storage.add(ls);
			ls =ls1;
		}
		
		for(List<TreeNode> lsTemp: storage)
		{
			TreeNode node = lsTemp.get(0);
			String str= "";
			do{
				str += node.getValue()+"->";
				node = node.getRight();
			}while(node != null);
			str+= "null";
			System.out.println(str);
		}
		
	}
	
	public static void verticalSum(TreeNode n)
	{
		if(n == null) return;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		verticalSum(n,hm,0);
		if(!hm.isEmpty())
			System.out.println(hm.entrySet());
	}
	
	private static void verticalSum(TreeNode n, HashMap<Integer,Integer> hm, int hd)
	{
		if(n == null) return;
		
		verticalSum(n.getLeft(),hm,hd-1);
		
		int prevSum = hm.get(hd) == null ? 0:hm.get(hd);
		hm.put(hd, prevSum+n.getValue());
		
		verticalSum(n.getRight(),hm,hd+1);
		
	}
	
	
	public boolean matches(TreeNode n, int[] arr, int level, int arrLength)
	{
		if(level < 0 || arrLength < 0) return false;
		if(arrLength != arr.length ) return false;
		if(arrLength > (int)Math.pow(2, level-1)) return false;
		TreeNode [][] matrix = new TreeNode[level][];
		matrix[0] = new TreeNode[1];
		matrix[0][0] = n;
		for(int i = 1 ; i < level;i++)
		{
			int j = 0, k = 0;
			matrix[i] = new TreeNode[(int)Math.pow(2, i)];
			while(j <matrix[i-1].length && matrix[i-1][j] != null)
			{	
				if(matrix[i-1][j].getLeft() != null)
				{
					matrix[i][k] = matrix[i-1][j].getLeft();
					k++;
				}
				if(matrix[i-1][j].getRight() != null)
				{
					matrix[i][k] = matrix[i-1][j].getRight();
					k++;
				}
				j++;
			}
		}
		int[] arr1 = new int[matrix[level-1].length];
		int num = 0;
		for(TreeNode x1 : matrix[level-1])
		{
				if(x1!=null)
				arr1[num++] = x1.getValue();
		}
		if(num != arrLength) return false;
		System.out.println(num);
		java.util.Arrays.sort(arr);
		java.util.Arrays.sort(arr1);
		for(int y = 0; y < arr.length; y++)
		{
			if(arr[y] != arr1[y]) return false;
		}
		return true;
	}
	
	public static boolean subTree(TreeNode s, TreeNode t)
	{
		if(s == t) return true;
		if(s == null) return false; 
		if(sameTree(s, t))
			return true;
		return subTree(s.getLeft(), t) || subTree(s.getRight(),t);
	}
}