package Tree;

public class AVLImplementation {

	public static void main(String[] args)
	{
		AVLNode r ;
		AVLNode n1 = new AVLNode(1);
		AVLNode n2 = new AVLNode(2);
		AVLNode n3 = new AVLNode(3);
		
		AVLTree avl = new AVLTree(n1);
		
		avl.setRoot(avl.insert((AVLNode)avl.getRoot(), n2));
		//BinaryTree.inOrderIterative(avl.getRoot());
		avl.setRoot(avl.insert((AVLNode)avl.getRoot(), n3));
		//BinaryTree.inOrderIterative(avl.getRoot());
		avl.setRoot(avl.insert((AVLNode)avl.getRoot(), new AVLNode(-3)));
		avl.setRoot(avl.insert((AVLNode)avl.getRoot(), new AVLNode(-2)));
		new BinaryTree().levelOrderTraversal(avl.getRoot());
	}
}
