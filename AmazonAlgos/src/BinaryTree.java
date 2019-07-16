import java.util.Objects;

enum TraversalApproches {
	IN_ORDER, PRE_ORDER, POST_ORDER
}

class BTree<M> {
	private Node<M> root;

	BTree() {

	}

	public void add(int key, M value) {
		if (Objects.isNull(root)) {
			root = new Node<>();
			addKeyValueToNode(key, value);
		} else {
			creatingChildNodes(key, value, root);
		}
	}

	public void traversal(TraversalApproches traversalApproches) {
		// left -> root -> right
		if (traversalApproches == TraversalApproches.IN_ORDER) {
			InOrderTraversal(root);
		} else if (traversalApproches == TraversalApproches.PRE_ORDER) {
			// root -> left -> right
			preOrderTraversal(root);
		} else if (traversalApproches == TraversalApproches.POST_ORDER) {
			postOrderTraversal(root);
		}
	}

	private void postOrderTraversal(BTree<M>.Node<M> root) {
		if (root != null) {
			postOrderTraversal(root.leftNode);
			postOrderTraversal(root.rightNode);
			System.out.println(root);
		}

	}

	private void preOrderTraversal(BTree<M>.Node<M> root) {
		if (root != null) {
			System.out.println(root);
			preOrderTraversal(root.leftNode);
			preOrderTraversal(root.rightNode);
		}

	}

	private void InOrderTraversal(Node<M> root) {
		if (root != null) {
			InOrderTraversal(root.leftNode);
			System.out.println(root);
			InOrderTraversal(root.rightNode);
		}

	}

	private void creatingChildNodes(int key, M value, Node<M> currentNode) {
		if (currentNode.key < key) {
			// right movement
			if (currentNode.rightNode == null) {
				currentNode.rightNode = new Node<>(key, value);
			} else {
				creatingChildNodes(key, value, currentNode.rightNode);
			}
		} else {
			// left movement
			if (currentNode.leftNode == null) {
				currentNode.leftNode = new Node<>(key, value);
			} else {
				creatingChildNodes(key, value, currentNode.leftNode);
			}
		}
	}

	private void addKeyValueToNode(int key, M value) {
		root.setKey(key);
		root.setValue(value);

	}

	//Time Complexity O(log n)
	public Node<M> findByKey(int key) {
		Node<M> found = root;

		while (found.key != key) {
			if (key < found.key) {
				found = found.leftNode;
			} else {
				found = found.rightNode;
			}
			if (Objects.isNull(found))
				return null;
		}

		return found;
	}

	class Node<V> {
		private int key;
		private V value;
		private Node<V> leftNode;
		private Node<V> rightNode;

		public Node() {
		}

		public Node(int key, V val) {
			this.key = key;
			this.value = val;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Node<V> getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node<V> leftNode) {
			this.leftNode = leftNode;
		}

		public Node<V> getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node<V> rightNode) {
			this.rightNode = rightNode;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode
					+ "]";
		}

	}
}

public class BinaryTree {

	public static void main(String[] args) {
		BTree<String> bt = new BTree<>();
		bt.add(8, "aqib");
		bt.add(5, "ali");
		bt.add(6, "test");
		bt.add(10, "afzal");
		bt.add(11, "shj");
		bt.add(9, "jhwl");
		 bt.traversal(TraversalApproches.POST_ORDER);
//		System.out.println(bt.findByKey(99));
		// System.out.println(bt);
	}
}
