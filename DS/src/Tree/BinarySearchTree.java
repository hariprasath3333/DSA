package Tree;

public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public BinarySearchTree(int d){
		root = new Node(d);
	}
	
	public void print() {
		inOrderTraversal(root);
	}
	
	public void insert(int d) {
		root = insert(root, d);
	}
	
	private Node insert(Node root, int d) {
		
		if(root == null) {
			return new Node(d);
		}
		
		if(d < root.data) {
			root.left = insert(root.left, d);
		}else if( d > root.data) {
			root.right = insert(root.right, d);
		}
			
		return root;
	}
	
	public void delete(int d) {
		root = delete(root, d);
	}
	
	private Node delete(Node node, int d) {
		
		if(node == null)
			return null;
		
		if(d < node.data) {
			node.left = delete(node.left, d);
		}else if( d > node.data) {
			node.right = delete(node.right, d);
		}else{
			if(node.left == null) {
				return node.right;
			} else if(node.right == null) {
				return node.left;
			} else {
				node.data = min(node.right);
				node.right = delete(node.right, node.data);
			}
		}
		
		

		
		return node;
	} 
	
	private int min(Node node) {
		int min = node.data;
		Node temp = node.left;
		while(temp != null) {
			min = temp.data;
			temp = temp.left;
		}
		
		return min;
	}
	
	private void inOrderTraversal(Node node) {
		
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);
		}
	}
	
	class Node{
		Node right;
		Node left;
		int data;
		
		Node(){
			
		}
		
		Node(int d){
			data = d;
			left = right = null;
		}
	}

}
