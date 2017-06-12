package Tree;

class AVLNode extends TreeNode
{

	int height;
	public AVLNode(int value) {
		super(value);
		this.height = 1;
	}
	
}

public class AVLTree extends BinarySearchTree{
	
	public AVLTree(TreeNode root) {
		super(root);
	}
	
	private int getHeight(AVLNode n)
	{
		return (n == null)?0:n.height;
	}
	
	private AVLNode rotateRight(AVLNode n)
	{
		AVLNode left =null;
		if(n.getLeft() instanceof AVLNode)		
		left = (AVLNode)n.getLeft();
		
		AVLNode l = (AVLNode)left.getRight();
		left.setRight(n);
		n.setLeft(l);
		
		n.height = Math.max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1;
		left.height = Math.max(getHeight(left.getLeft()), getHeight(left.getRight())) + 1;
		
		return left;
	}
	
	private AVLNode rotateLeft(AVLNode n)
	{
		AVLNode right = null;
		if(n.getRight() instanceof AVLNode)
		right = (AVLNode)n.getRight();
		
		AVLNode temp = (AVLNode)right.getLeft();
		right.setLeft(n);
		n.setRight(temp);
		
		n.height = Math.max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1;
		right.height = Math.max(getHeight(right.getLeft()), getHeight(right.getRight())) + 1;
		
		return right;	
	}
	
	private int getBalanceFactor(AVLNode n)
	{
		if(n == null)return 0;
		return getHeight(n.getLeft()) - getHeight(n.getRight());
	}
	
	public AVLNode insert(AVLNode root, AVLNode node)
	{
		if(root == null) return node;
		if(node.getValue() > root.getValue()) 
			root.setRight(insert((AVLNode)root.getRight(),node));
		else if(node.getValue() < root.getValue())
			root.setLeft(insert((AVLNode)root.getLeft(),node));
		else
			return root;
		root.height = Math.max(this.getHeight((AVLNode)root.getRight()), this.getHeight((AVLNode)root.getLeft()))+1;
		int balance = getBalanceFactor(root);
		if(balance > 1 && node.getValue() < root.getLeft().getValue())
			return rotateRight(root);
		if(balance < -1 && node.getValue() > root.getRight().getValue())
			return rotateLeft(root);
		if(balance > 1 && node.getValue() > root.getLeft().getValue())
		{
			root.setLeft(rotateLeft((AVLNode)root.getLeft()));
			return rotateRight(root);
		}
		if(balance < -1 && node.getValue() < root.getRight().getValue())
		{
			root.setRight(rotateLeft((AVLNode)root.getRight()));
			return rotateLeft(root);
		}
		return root;
	}
	
}
