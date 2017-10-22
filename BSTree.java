import org.w3c.dom.Node;

public class BSTree {
	private class BSTNode {
		public BSTNode(Comparable value) {
			data = value;
		}
		public Comparable data; 
		public BSTNode left; 
		public BSTNode right; 

}
private BSTNode root;
public boolean find(Comparable value) {
	return find(value,root);
}
public boolean find(Comparable value, BSTNode node) {
	if(node.data.compareTo(value)==0) {
		return true;
	}
	else if(node.data.compareTo(value)<0) {
		return find(value,node.left);
			
		}
	else {
		return find(value, node.right);
	}

}
public BSTNode insert(Comparable value) {
	return insert(value,root);
}
public BSTNode insert( Comparable value, BSTNode node) {
	
	if (node == null) {
		return new BSTNode(value);
	}
	if (value.compareTo(root.data) < 0) {
		root.left = insert(value, root.left);
		return root;
	} else {
		root.right = insert(value,root);
		return root;
	}
}
public BSTNode delete(Comparable value) {
	return delete(root, value);
}
public BSTNode delete(BSTNode node, Comparable value) {
	
	if (root == null)
		return null;
	if (root.data.compareTo(value) == 0) { 
		if (root.left == null) 
			return root.right;
		else if (root.right == null)
			return root.left;
		else { 
			if (root.right.left == null) { 
				
				root.data = root.right.data;
				
				root.right = root.right.right;
				return root;
			} else {
				
				root.data = removesmallest(root.right);
				return root;
			}
		}
	} else if (value.compareTo(root.data) < 0) { 
		root.left = delete(root.left, value);
		return root;
	} else {
		root.right = delete(root.right, value); 
		return root;
	}
}


private Comparable removesmallest(BSTNode node) {
	
	if (root.left.left == null) {
		Comparable smallest = root.left.data;
		root.left = root.left.right;
		return smallest;
	} else {
		return removesmallest(root.left);
	}

}
public Object toStringInOrder() {
	return toStringInOrder(root);
}
private Object toStringInOrder(BSTNode tree) {
	Object order=null;
	if (tree != null) {
		toStringInOrder(tree.left);
		order = order + " " + tree.data;
		toStringInOrder(tree.right);
	}
return order;
}
public String toStringPreOrder() {
	return toStringPreorder(root);
}
public String toStringPreorder(BSTNode tree) {
	return null;
	
}

}
