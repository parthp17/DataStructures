package Tree;

public class BSTImplementation {

	public static void main(String[] args)
	{
		int[] arr = {3,5,6,98,1,4,63,0};
		TreeNode n = BinarySearchTree.arrayToBST(arr);
		//BinaryTree.inOrderIterative(n);
		//System.out.println(BinarySearchTree.findMin(n).getValue());		
		//System.out.println(n.getValue());
		//System.out.println(BinarySearchTree.inOrderNext(n, n.getRight().getRight()).getValue());
		int[] index = new int[1];
		index[0] = 8;
		//System.out.println(BinarySearchTree.kthSmallestElement(n, index).getValue());		
		//System.out.println(BinarySearchTree.search(n, new TreeNode(3)));
		//System.out.println(BinarySearchTree.delete(n, n).getLeft().getValue());
		//BinarySearchTree.printValuesInRange(n,5,63);
		
		//BinarySearchTree.inOrderWithStack(BinarySearchTree.mergeBST(n, n));
		//System.out.println(BinarySearchTree.hasOnlyOneChild(new int[]{10,2,3,4,5,6,7,8,9}));
		//n = BinarySearchTree.constructPreorderBST(new int[]{10,8,6,9,12,13,14});
		BinaryTree.inOrderIterative(n);
		BinaryTree.inOrderIterative(BinarySearchTree.correctBST(n));

		//System.out.println(BinarySearchTree.cielingBST(n, 0));
		//System.out.println();
		//BinarySearchTree.bstToGreaterKeyTree(n, new int[1]);
		//BinaryTree.inOrderIterative(n);
		
		//System.out.println(BinarySearchTree.hasTriplet(n));
		//System.out.println(BinarySearchTree.isPairEqualToSum(n, 7));
		
		//BinarySearchTree.removeBSTkeysOutofRange(n, 2, 76);
		//BinarySearchTree.inOrderIterative(n);
//		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
//		n1.setRight(n2);
//		n2.setRight(n3);
//		BinarySearchTree.inOrderWithStack(BinarySearchTree.convertDLLtoBST(n1));
		//System.out.println(BinarySearchTree.distanceBetweenNodesBST(new int[]{5,6,3,1,2,4}, 2, 4));
	}
}