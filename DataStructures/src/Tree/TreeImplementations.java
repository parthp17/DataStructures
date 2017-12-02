package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeImplementations {

	public static void main(String[] args)
	{
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);
		
		n1.setRight(n3);
		n1.setLeft(n2);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		n4.setLeft(n8);
		n5.setRight(n9);
		n6.setLeft(n10);
		n7.setRight(n11);
		n11.setLeft(n12);
		n8.setLeft(n13);
		n9.setRight(new TreeNode(14));
		n10.setLeft(new TreeNode(15));
		//n13.setRight(new TreeNode(54));
		//n12.setRight(new TreeNode(54));
		n8.setRight(new TreeNode(8));
		BinaryTree objBinaryTree = new BinaryTree();
		//BinaryTree objBinaryTree = null;
		objBinaryTree.setRoot(n1);
		int[] in = new int[1];
		//System.out.println(objBinaryTree.matches(n1, new int[]{4,5,6,7}, 4, 4));
		BinaryTree.printAncestor(n1, 13);
		//System.out.println(BinaryTree.maxSumFromRootToLeaf(n1, in));
		//System.out.println(in[0]);
		
		System.out.println( BinaryTree.leastCommonAncestor(n1, n2, n3).getValue());
		
		//System.out.println("Hieght " + objBinaryTree.getHeight(objBinaryTree.getRoot()));
		
		/*System.out.println("preOrder traversal");
		objBinaryTree.preOrderTraversal(objBinaryTree.getRoot());
		
		System.out.println("inOrder traversal");
		objBinaryTree.inOrderTraversal(objBinaryTree.getRoot());
		
		System.out.println("postOrder traversal");
		objBinaryTree.postOrderTraversal(objBinaryTree.getRoot());
		
		System.out.println("levelOrderTraversal traversal");
		objBinaryTree.levelOrderTraversal(objBinaryTree.getRoot());
		
		System.out.println("levelOrderTraversal traversal");
		objBinaryTree.levelOrderStorage(objBinaryTree.getRoot());
		
		System.out.println("levelOrderTraversalDFS traversal");
		ArrayList<ArrayList<TreeNode>> storage = new ArrayList<ArrayList<TreeNode>>();
		objBinaryTree.levelOrderStorage(objBinaryTree.getRoot(),0,storage);
		
		for(ArrayList<TreeNode> ls: storage)
		{
			StringBuffer str = new StringBuffer();
			for(TreeNode t : ls)
			{
				str.append(t.getValue());
				str.append(" ");
			}
			System.out.println(str);
		}
		
		System.out.println("isBalanced ");
		System.out.println(objBinaryTree.isBalanced(objBinaryTree.getRoot()));
		
		System.out.println(objBinaryTree.checkHeight(objBinaryTree.getRoot()) != Integer.MIN_VALUE);
		String[] str = {"3","{([])}","({[)]}","[a+(b*c)]/d"};
		str = checkParanthesis(str);
		for(String st : str)
		System.out.println(st);
		System.out.println(isPalindrome("Parth"));
		System.out.println(isPalindrome("abcdedcba"));
		System.out.println(isPalindrome("abccba"));
		System.out.println(reverseString("Parth"));
		System.out.println(objBinaryTree.isBST(objBinaryTree.getRoot()));
		
		System.out.println("levelOrderTraversal");
		objBinaryTree.levelOrderStorage(objBinaryTree.getRoot());

		System.out.println("Root to leaf sum");
		BinaryTree.rootToLeafSums(n1);

		BinaryTree.binaryToBST(n1);
		
		System.out.println("levelOrderStorage");
		objBinaryTree.levelOrderStorage(objBinaryTree.getRoot());

		System.out.println("Root to leaf sum");
		BinaryTree.rootToLeafSums(n1);
		
		System.out.println("Root to leaf sum");
		System.out.println(BinaryTree.hasSum(n1, 30));
		
		System.out.println("Paths from root to leaf");
		List<String> ls = BinaryTree.printPath(n1);
		
		for(String s : ls)
			System.out.println(s);
		
		System.out.println("max time");
		System.out.println(StringUtility.maxTime(1, 7, 2, 7));
		
		System.out.println("mirror");
		BinaryTree.mirror(n1);
		objBinaryTree.levelOrderTraversal(objBinaryTree.getRoot());
		
		System.out.println("Same tree");
		System.out.println(BinaryTree.sameTree(n1, n1));
		System.out.println(BinaryTree.sameTree(n1, n2));
		System.out.println(StringUtility.nextLargestPalindrome(1245));*/
		
		/*TreeNode head = BinaryTree.treeToCircularDoubleLinkedList(n1);
		TreeNode tail =head;*/
		//System.out.println(tail.getValue());
		
		/*do{
			System.out.println(head.getValue());
		}while((head = head.getRight()) != tail);*/
		
		
		//System.out.println(BinaryTree.getLeafCount(n1));
	//BinaryTree.printLevelOrderZigZag(n1);
//		TreeNode N1 = new TreeNode(3);
//		TreeNode N2 = new TreeNode(2);
//		TreeNode N3 = new TreeNode(1);
//		N1.setLeft(N2);
//		N1.setRight(N3);
		
	/*	System.out.println(BinaryTree.parentEqualTosumOfChildrens(n1));
*/	
		
	
		/*TreeNode N1 = new TreeNode(3);
		TreeNode N2 = new TreeNode(2);
		TreeNode N3 = new TreeNode(0);
		N1.setLeft(N2);
		N1.setRight(N3);
		TreeNode N4 = new TreeNode(5);
		N4.setLeft(N1);
		TreeNode ntemp = BinaryTree.convertToChildSumTree(N4);
		System.out.println("levelOrderTraversal traversal");
		objBinaryTree.levelOrderTraversal(ntemp);*/
		
		/*BinaryTree.getDiameter(n1, in);
		System.out.println(in[0]);*/
		
		//BinaryTree.inOrderWithStack(n1);
		//BinaryTree.doubleTree(n1);
		//BinaryTree.inOrderIterative(n1);
		
		//System.out.println(BinaryTree.getWidth(n1));
		
		//System.out.println(BinaryTree.foldable(n1));
		//BinaryTree.printAncestor(n1, n13);
		//System.out.println(BinaryTree.isSumTree(N1));
		
		//BinaryTree.connectNodes(n1);
		
		//BinaryTree.verticalSum(n1);
		//printPI();
		
	}
}