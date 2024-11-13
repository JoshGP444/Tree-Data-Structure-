//Part 6:  Simple Java Code for Tree Data Structure

public class BinarySearchTree{
	static class Node{
		int value;
		Node left, right;

		Node(int value){
			this.value = value;
			left = right = null;
		}
	}
	Node root;

//Method of insertion...
	public void insert(int value){
		root = insertRec(root, value);
	}
	private Node insertRec(Node root, int value){
		if(root == null){
			root = new Node(value);
			return root;
		}
		if(value < root.value){
			root.left = insertRec(root.left, value);
		}
		else if(value > root.value){
			root.right = insertRec(root.right, value);
		}
		return root;
	}
//Method for in-order traversal
	public void inOrderTraversal(){
		inOrderTraversalRec(root);
	}
	public void inOrderTraversalRec(Node root){
		if(root != null){
			inOrderTraversalRec(root.left);
			System.out.print(root.value+" ");
			inOrderTraversalRec(root.right);
		}
	}
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(15);
		System.out.println("in-order traversal");
		bst.inOrderTraversal();
	}
}