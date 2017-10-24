package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree extends BinaryTree{

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public BinarySearchTree(TreeNode root)
	{
		this.root = root;
	}
	
	public static TreeNode insert(TreeNode root, TreeNode n)
	{
		if(root == null) return n;
		else
		{
			if(root.getValue() < n.getValue())
				root.setRight( insert(root.getRight(),n));
			else
				root.setLeft( insert(root.getLeft(),n));
		}
		return root;
	}
	
	public static boolean search(TreeNode root, TreeNode n)
	{
		if(root == null) return false;
		
		if(root.getValue() < n.getValue())
			return search(root.getRight(),n);
		else if(root.getValue() > n.getValue())
			return search(root.getLeft(), n);
			else
				return true;
	}
	
	public static TreeNode delete(TreeNode root, TreeNode n)
	{
		if(root == null) return null;
		TreeNode p,p2;
		if(search(root, n))
		{
			if(root.getValue() == n.getValue())
			{
				TreeNode l = root.getLeft();
				TreeNode r = root.getRight();
				
				if(l==null && r==null)
				{
					return null;
				}
				else if(l==null)
				{
					p = r;
				}
				else if(r == null)
				{
					p = l;
				}
				else
				{
					p2 = r;
					p = r;
					while(p2.getLeft()!=null) p2 = p2.getLeft();
					p2.setLeft(l);
				}
				return p;
			}
			else if(root.getValue() < n.getValue())
			{
				root.setRight(delete(root.getRight(),n));
			}
			else
			{
				root.setLeft(delete(root.getLeft(),n));
			}
			return root;
		}
		else
		{
			return null;
		}
	}
	
	public static TreeNode arrayToBST(int[] arr)
	{
		java.util.Arrays.sort(arr);
		return arrayToBST(arr,0,arr.length-1);
	}
	private static TreeNode arrayToBST(int[] arr, int start, int end)
	{
		if(start > end) return null;
		
		int mid = start + end;
		mid /= 2;
		
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeft(arrayToBST(arr,start,mid-1));
		n.setRight(arrayToBST(arr, mid+1, end));
		return n;
	}
	
	public static TreeNode findMin(TreeNode n)
	{
		if(n == null) return null;
		
		/*TreeNode left = n.getLeft();
		if(left == null) return n;
		else return findMin(left);
		*/
		while(n.getLeft() != null)
		{
			n = n.getLeft();
		}
		return n;
	}
	
	public boolean isBST(TreeNode n)
	{
		if(n == null) return true;
		if((n.getLeft() != null && n.getLeft().getValue() > n.getValue())||
				(n.getRight() != null && n.getRight().getValue() <= n.getValue()))
			return false;
		return isBST(n.getLeft()) && isBST(n.getRight());
	}
	
	public static TreeNode inOrderNext(TreeNode root, TreeNode n)
	{
		if( n == null || root == null) return null;
		if(n.getRight() != null) return findMin(n.getRight());
		else
		{
				TreeNode next = null;
				while(root != null)
				{
					if(n.getValue() > root.getValue())
					{
						root = root.getRight();
					}
					else if(n.getValue() < root.getValue())
					{
						next = root;
						root.getLeft();
					}
					else 
						break;
				}
				return next;
			
		}
	}
	
	
	public static TreeNode inOrderNext(TreeNode root, int val)
	{
		if(root == null) return null;
		if(root.getValue() == val)
		{
			if(root.getRight() != null)
			{
				TreeNode prev = null;
				while(root != null)
				{
					prev = root;
					root = root.getLeft();
				}
				return prev;
			}
			else
				return null;
		}
		else if(val > root.getValue())
		{
			return inOrderNext(root.getRight(), val);
		}
		else
		{
			TreeNode ret = inOrderNext(root.getRight(), val);
			return ret == null?root:ret;
		}
	}
		
	
	public static TreeNode kthSmallestElement(TreeNode n, int[] k)
	{
		if(n == null || k[0] <= 0) return n;
		
		TreeNode l = kthSmallestElement(n.getLeft(), k);
		if(l != null)return l;
		k[0]-=1;
		if(k[0] == 0) return n;
		
		TreeNode r = kthSmallestElement(n.getRight(), k);
		if(r != null) return r;
		return null;
	}
	
	public static void printValuesInRange(TreeNode n, int k1, int k2)
	{
		if(n == null) return;
		int max = k1>k2?k1:k2;
		int min = k1>k2?k2:k1;
		if(min < n.getValue())
			printValuesInRange(n.getLeft(), min, max);
		if(n.getValue() >= min && n.getValue() <= max)
			System.out.println(n.getValue());
		if(max > n.getValue())
			printValuesInRange(n.getRight(), min, max);
	}
	
	public static TreeNode LCA(TreeNode root, int n1, int n2)
	{
		if(contains(root,n1) && contains(root, n2))
		{
			int min = n1<n2?n1:n2;
			int max = n1 == min?n2:n1;
			return lowestCommonAncestor(root,min, max);
		}
		else return null;
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, int min, int max)
	{
		if(root.getValue() < min) return lowestCommonAncestor(root.getRight(), min, max);
		if(root.getValue() > max) return lowestCommonAncestor(root.getLeft(), min, max);
		return root;
	}
	
	public static boolean contains(TreeNode root, int n)
	{
		if(root == null ) return false;
		if(root.getValue() == n) return true;
		else if(root.getValue() < n) return contains(root.getRight(), n);
		else return contains(root.getLeft(), n);
		
	}
	
	public static int maxBSTinBinarytree(TreeNode n, int[] size)
	{
		if(n == null) return Integer.MIN_VALUE;
		
		int lmax = maxBSTinBinarytree(n.getLeft(), size);
		int rmax = maxBSTinBinarytree(n.getRight(), size);
		
		if(lmax == Integer.MIN_VALUE && rmax == Integer.MIN_VALUE && size[0] == 0 )
		{
			size[0]++;
			return n.getValue();
		}
		
		if(lmax <= n.getValue() && n.getValue() < rmax)
		{
			size[0] = size[0] >= BinaryTree.size(n)? size[0]:BinaryTree.size(n);
			return rmax;
		}
		else
		{
			return Integer.MIN_VALUE;	
		}
	}
	
	public static TreeNode mergeBST(TreeNode n1, TreeNode n2)
	{
		//inorder traversal for both tree
		
		if(n1 == null) return n2;
		if(n2 ==  null) return n1;
		List<Integer> l1 = new LinkedList<Integer>();
		List<Integer> l2 = new LinkedList<Integer>();
		TreeNode current = n1;
		TreeNode pre;
		while(current != null)
		{
			if(current.getLeft() == null)
			{
				l1.add(current.getValue());
				current = current.getRight();
			}
			else
			{
				pre = current.getLeft();
				
				while(pre.getRight() != null && pre.getRight() != current) pre = pre.getRight();
				
				if(pre.getRight() == null )
				{
					pre.setRight(current);
					current= current.getLeft();
				}
				else
				{
					pre.setRight(null);
					l1.add(current.getValue());
					current = current.getRight();
				}
			}
		}
		
		Stack<TreeNode> stack  = new Stack<TreeNode>();
		
		while(n2 != null)
		{
			stack.push(n2);
			n2 = n2.getLeft();
		}
		
		while(!stack.isEmpty())
		{	
			n2 = stack.pop();
			l2.add(n2.getValue());
			if(n2.getRight() != null)
			{
				n2 = n2.getRight();
			
			while(n2 != null)
			{
				stack.push(n2);
				n2 = n2.getLeft();
			}
			}
		}
		
		Integer[] arr1 = new Integer[l1.size()];
		Integer[] arr2 = new Integer[l2.size()];
		int[] arr3 = new int[l1.size()+l2.size() ];
		arr1 = l1.toArray(arr1);
		arr2 = l2.toArray(arr2);
		
		int arr1p = arr1.length -1;
		int arr2p = arr2.length-1;
		int arr3p = arr3.length - 1;
		while(arr1p >= 0 || arr2p >=0 )
		{
			if(arr1p > -1 && arr2p > -1)
			{
				if(arr1[arr1p] > arr2[arr2p])
				{
					arr3[arr3p] = arr1[arr1p];
					arr1p--;
				}
				else
				{
					arr3[arr3p] = arr2[arr2p];
					arr2p--;
				}
			}
			else if(arr1p > -1)
			{
				arr3[arr3p] = arr1[arr1p];
				arr1p--;
			}
			else
			{
				arr3[arr3p] = arr2[arr2p];
				arr2p--;
			}
			arr3p--;
		}
		
		return arrayToBST(arr3);
	}
	
	public static TreeNode mergeUsingDLL(TreeNode n1, TreeNode n2)
	{
		//Tree to DLL
		// Merge DLL
		///DLL to BST
		
		BinarySearchTree.binaryToBST(n1);
		BinarySearchTree.binaryToBST(n2);
		
		n1 = treeToCircularDoubleLinkedList(n1);
		n2 = treeToCircularDoubleLinkedList(n2);
		
		TreeNode n = mergeDLL(n1,n2);
		
		return convertDLLtoBST(n);
		
	}
	
	public static TreeNode mergeDLL(TreeNode n1, TreeNode n2)
	{
		TreeNode n = null;
		if(n1 == null) return n2;
		if(n2 == null) return n1;
		
		if(n1.getValue() <= n2.getValue())
		{
			n = n1;
			n.setRight(mergeDLL(n1.getRight(), n2));
		}
		else
		{
			n = n2;
			n.setRight(mergeDLL(n1, n2.getRight()));
		}
		return n;
	}
	
	public static TreeNode convertDLLtoBST(TreeNode n)
	{
		int size = BinaryTree.size(n);
		return sortedDLLtoBST(size, new TreeNode[]{n});
	}
	public static TreeNode sortedDLLtoBST(int size, TreeNode[] root)
	{
		if(size <= 0 ) return null;
		TreeNode left = sortedDLLtoBST(size/2, root);
		TreeNode r = root[0];
		root[0] = root[0].getRight();
		r.setLeft(left);
		r.setRight(sortedDLLtoBST(size - size/2 - 1, root));
		return r;
	}
	
	public static TreeNode sortedDLLtoBST(TreeNode n, int start, int end)
	{
		if(start > end) return null;
		int mid = (start+end)/2;
		TreeNode left = sortedDLLtoBST(n, start, mid -1);
		TreeNode root = n;
		n= n.getRight();
		root.setRight(sortedDLLtoBST(n, mid+1, end));
		root.setLeft(left);
		return root;
	}
	
	public static boolean hasOnlyOneChild(int[] arr)
	{
		for(int i = 0;i < arr.length-1;i++)
		{
			if ((arr[i]-arr[i+1])*(arr[i] - arr[arr.length-1]) < 0) return false;
		}
		return true;
	}
	
	public static TreeNode constructPreorderBST(int[] arr)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode n = new TreeNode(arr[0]);
		stack.push(n);
		
		for(int i = 1 ; i < arr.length; i++)
		{
			TreeNode temp = null;
			
			while(!stack.isEmpty() && arr[i] > stack.peek().getValue())
			temp = stack.pop();
			
			if(temp !=null)
			{
				temp.setRight(new TreeNode(arr[i]));
				stack.push(temp.getRight());
			}
			else
			{
				temp = stack.peek();
				temp.setLeft(new TreeNode(arr[i]));
				stack.push(temp.getLeft());
			}
		}
		return n;
	}
	
	public static TreeNode correctBST(TreeNode n)
	{
		
		TreeNode[] pointer = new TreeNode[4];
		correctSwappedNodesBST(n, pointer);
		
		if(pointer[0] != null && pointer[2] != null)
		{
			int temp = pointer[0].getValue();
			pointer[0].setValue(pointer[2].getValue());
			pointer[2].setValue(temp);
		}
		else if(pointer[0] != null && pointer[1] !=null )
		{
			int temp = pointer[0].getValue();
			pointer[0].setValue(pointer[1].getValue());
			pointer[1].setValue(temp);
		}
		return n;
	}
	
	public static void correctSwappedNodesBST(TreeNode n, TreeNode[] pointer)
	{
		if( n !=  null)
		{
			correctSwappedNodesBST(n.getLeft(),pointer);
			
			if(pointer[3] != null && n.getValue() < pointer[3].getValue())
			{
				if(pointer[0] == null)
				{
					pointer[0] = pointer[3];
					pointer[1] = n;
				}
				else
				{
					pointer[2] = n;
				}
			}
			pointer[3] = n;
			correctSwappedNodesBST(n.getRight(), pointer);
		}
	}
	
	public static TreeNode floorBST(TreeNode n, int value)
	{
		if (n == null) return null;
		
		else if(n.getValue() >= value )
		{
			if(n.getLeft()!= null && n.getLeft().getValue() < value) return n.getLeft();
			else
				return floorBST(n.getLeft(),value);
		}
		else
		{
			if(n.getRight() != null && n.getRight().getValue() >= value) return n;
			else
				return floorBST(n.getRight(), value);
		}
	}
	
	public static int cielingBST(TreeNode n, int value)
	{
		if(n == null) return -1;
		else if(n.getValue() <= value)
		{
			if(n.getRight()!= null && n.getRight().getValue() > value) return n.getRight().getValue();
			else
				return cielingBST(n.getRight(), value);
		}
		else
		{
			if(n.getLeft() != null && n.getLeft().getValue() <= value) return n.getValue();
			else
				return cielingBST(n.getLeft(), value);
		}
	}
	
	public static void bstToGreaterKeyTree(TreeNode n, int[] sum)
	{
		if(n == null) return;
		bstToGreaterKeyTree(n.getRight(), sum);
		sum[0]+=n.getValue();
		n.setValue(sum[0]);
		bstToGreaterKeyTree(n.getLeft(), sum);
		
		/*int right = 0;
		if(n.getRight()!= null)
		{
			right = bstToGreaterKeyTree(n.getRight(), sum);
		}
		
		if(right != 0)
		n.setValue(right+n.getValue());
		else
			n.setValue(sum+n.getValue());
		
		if(n.getLeft()!=null)
		{	
			return bstToGreaterKeyTree(n.getLeft(),n.getValue());
		}
		return n.getValue();*/
	}
	
	public static boolean hasTriplet(TreeNode n)
	{
		// BST to DLL
		TreeNode head = BinaryTree.treeToCircularDoubleLinkedList(n);
		TreeNode tail = head.getLeft();
		while(head.getRight() != tail && head.getValue() < 0)
		{
			if(isPairEqualToSum(head.getRight(), tail, Math.abs(head.getValue())))
			{
				return true;
			}
			else
			{
				head = head.getRight();
			}
		}
		return false;
	}
	
	public static boolean isPairEqualToSum(TreeNode head, TreeNode tail, int sum)
	{
		int value;
		
		while(head != tail)
		{
			value = head.getValue()+tail.getValue() ;
			if(value==sum) return true;
			else if(value < sum) head = head.getRight();
			else tail = tail.getLeft();
		}
		return false;
	}
	public static boolean isPairEqualToSum(TreeNode n, int sum)
	{
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode curr1 = n;
		TreeNode curr2= n;
		boolean flag1 = true, flag2 = true;
		int val1 = 0 ,val2 = 0;
		
		while(true)
		{
			while(flag1)
			{
				if(curr1 != null)
				{
					stack1.push(curr1);
					curr1= curr1.getLeft();
				}
				else
				{
					if(stack1.isEmpty())
						flag1 = false;
					else
					{
						curr1 = stack1.pop();
						val1 = curr1.getValue();
						curr1 = curr1.getRight();
						flag1 = false;
					}
				}
			}
			
			while(flag2)
			{
				if(curr2 != null)
				{
					stack2.push(curr2);
					curr2= curr2.getRight();
				}
				else
				{
					if(stack2.isEmpty())
						flag2 = false;
					else
					{
						curr2 = stack2.pop();
						val2 = curr2.getValue();
						curr2 = curr2.getRight();
						flag2 = false;
					}
				}
			}
			
			if(val1 + val2 == sum) return true;
			else if(val1 + val2 < sum) flag1 = true;
			else flag2 = true;
			
			if(val1 >= val2) return false;
		}
	}
	
	public static TreeNode removeBSTkeysOutofRange(TreeNode n, int min, int max)
	{
		if(n == null) return null;
		
		n.setLeft(removeBSTkeysOutofRange(n.getLeft(), min, max));
		n.setRight(removeBSTkeysOutofRange(n.getRight(), min, max));
		
		if(n.getValue() < min)
		{
			TreeNode node = n.getRight();
			n = null;
			return node;
		}
		
		if(n.getValue() > max)
		{
			TreeNode node =n.getLeft();
			n = null;
			return node;
		}
		return n;	
	}
	
	public static int distanceBetweenNodesBST(int[] arr, int n1, int n2)
	{
		if(n1 == n2) return 0;
		TreeNode root = arrayToBST(arr);
		int bigger = 0;
		int smaller = n1 < n2 ? n1 : n2;
		if(smaller == n1) bigger = n2;
		else bigger = n1;
		return distance(root, smaller, bigger);
	}
	
	private static int distance(TreeNode root, int smaller, int bigger)
	{
		if(root.getValue() == smaller)
			return depth(root,bigger);
		else if(root.getValue() == bigger)
			return depth(root,smaller);
		else if(smaller < root.getValue() && bigger > root.getValue())
		{
			return depth(root,smaller) + depth(root,bigger);
		}
		else if(smaller < root.getValue() && bigger < root.getValue())
		{
			return distance(root.getLeft(),smaller, bigger );
		}
		else if(smaller > root.getValue() && bigger > root.getValue())
		{
			return distance(root.getLeft(),smaller,bigger);
		}
		
		return -1;
	}
	
	private static int depth(TreeNode root, int node)
	{
	    if(root == null) return -1;
	    if(root.getValue() == node) return 0;
	    int ans = 0;
	    if(root.getValue() > node)
	    ans = depth(root.getLeft(),node);
	    else if(root.getValue() < node)
	    ans  = depth(root.getRight(),node);
	    if(ans != -1)
	    ans++;
	    return ans;
	}
}