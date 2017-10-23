//import org.w3c.dom.Node;

public class BSTree {
	
	private class BSTNode {
		public Comparable data; 
		public BSTNode left; 
		public BSTNode right; 

		BSTNode(Comparable newdata) {
			data = newdata;
		}
	}
	
	private BSTNode root; 

	public void insert(Comparable value) {
		root = insert(root, value);
	}
	public boolean find(Comparable value) {
		return find(root, value);
	}
	public void delete(Comparable value) {
		root = delete(root, value);
	}

	
	public void print() {
		print(root);
	}


	private boolean find(BSTNode node, Comparable value) {
		if (node == null)
			return false;
		if (value.compareTo(node.data) == 0)
			return true;
		if (value.compareTo(node.data) < 0)
			return find(node.left, value);
		else
			return find(node.right, value);
	}


	private Comparable minimum(BSTNode node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.data;
		else
			return minimum(node.left);
	}

	
	private void print(BSTNode node) {
		if (node != null) {
			print(node.left);
			System.out.print(" " + node.data + " ");
			print(node.right);
		}
	}

	
	private BSTNode insert(BSTNode node, Comparable value) {
		if (node == null) {
			return new BSTNode(value);
		}
		if (value.compareTo(node.data) < 0) {
			node.left = insert(node.left, value);
			return node;
		} else {
			node.right = insert(node.right, value);
			return node;
		}
	}

	private BSTNode delete(BSTNode node, Comparable value) {
		if (node == null)
			return null;
		if (node.data.compareTo(value) == 0) { 
			if (node.left == null) 
				return node.right;
			else if (node.right == null) 
				return node.left;
			else { 
				if (node.right.left == null) { 
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (value.compareTo(node.data) < 0) { 
			node.left = delete(node.left, value);
			return node;
		} else {
			node.right = delete(node.right, value); 
			return node;
		}
	}

	
	private Comparable removeSmallest(BSTNode node) {
		if (node.left.left == null) {
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		} else {
			return removeSmallest(node.left);
		}
	}


public String toStringInOrder() {
	return toStringInOrder(root);
}
private String toStringInOrder(BSTNode node) {
	String order="";
	if (node != null) {
		toStringInOrder(node.left);
		order = order + " " + node.data;
		toStringInOrder(node.right);
	}
return order;
}
public String toStringPreOrder() {
	return toStringPreorder(root);
}
public String toStringPreorder(BSTNode node) {
	String order="";
	if(node != null) {
		order = order+ " " + node.data;
		toStringPreorder(node.left);
		toStringPreorder(node.right);
	
	}
	return order;
	
}

}
