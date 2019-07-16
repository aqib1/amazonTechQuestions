import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

enum TraversalTypes {
	LEVEL_ORDER, PRE_ORDER, POST_ORDER, IN_ORDER
}

class BT<V> {
	private Node<V> root;

	public BT() {

	}

	public BT(V value, int key) {
		addRoot(value, key);

	}

	private void addRoot(V value, int key) {
		if (Objects.isNull(root)) {
			root = new Node<>(value, key);
		} else {
			addChildNodes(root, value, key);
		}
	}

	public void add(int key, V value) {
		addRoot(value, key);
	}

	private void addChildNodes(Node<V> root, V value, int key) {
		if (key > root.key) {
			// right tree
			if (Objects.isNull(root.rightNode)) {
				root.rightNode = new Node<>(value, key);
			} else {
				addChildNodes(root.rightNode, value, key);
			}
		} else {
			// left tree
			if (Objects.isNull(root.leftNode)) {
				root.leftNode = new Node<>(value, key);
			} else {
				addChildNodes(root.leftNode, value, key);
			}
		}

	}

	public void traverseBST(TraversalTypes types) {
		// DFS
		if (types == TraversalTypes.IN_ORDER) {
			inOrderTraversal(root);
		} else if (types == TraversalTypes.PRE_ORDER) {
			preOrderTraversal(root);
		} else if (types == TraversalTypes.POST_ORDER) {
			postOrderTraversal(root);
		} else if (types == TraversalTypes.LEVEL_ORDER) {
			levelOrderTraversal(root);
		}
	}

	// BFS ->
	private void levelOrderTraversal(BT<V>.Node<V> root2) {
		Queue<Node<V>> queue = new LinkedList<>();
		queue.add(root2);
		while (!queue.isEmpty()) {
			Node<V> node = queue.poll();
			System.out.println(node);

			if (!Objects.isNull(node.leftNode)) {
				queue.add(node.leftNode);
			}
			
			if (!Objects.isNull(node.rightNode)) {
				queue.add(node.rightNode);
			}
		}
	}

	private void preOrderTraversal(BT<V>.Node<V> root2) {
		if (!Objects.isNull(root2)) {
			System.out.println(root2);
			preOrderTraversal(root2.leftNode);
			preOrderTraversal(root2.rightNode);
		}
	}

	private void postOrderTraversal(BT<V>.Node<V> root2) {
		if (!Objects.isNull(root2)) {
			postOrderTraversal(root2.leftNode);
			postOrderTraversal(root2.rightNode);
			System.out.println(root2);
		}
	}

	private void inOrderTraversal(BT<V>.Node<V> root) {
		if (!Objects.isNull(root)) {
			inOrderTraversal(root.leftNode);
			System.out.println(root);
			inOrderTraversal(root.rightNode);
		}

	}
	
	public void leftViewOfBT() {
		preOrderTraversal(root.leftNode);
	}

	public Node<V> findNode(int key) {
		return find(root, key);
	}

	private Node<V> find(Node<V> node, int key) {
		if (Objects.isNull(node))
			return null;
		if (key == node.key) {
			return node;
		} else if (key > node.key) {
			return find(node.rightNode, key);
		} else {
			return find(node.leftNode, key);
		}
	}

	class Node<M> {
		private int key;
		private M value;
		private Node<M> leftNode;
		private Node<M> rightNode;

		public Node() {
		}

		public Node(M value, int key) {
			this.value = value;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode
					+ "]";
		}

	}
}

public class Bi_Tree {
	public static void main(String[] args) {
		BT<String> bt = new BT<>();
		bt.add(8, "aqib");
		bt.add(5, "ali");
		bt.add(6, "test");
		bt.add(10, "afzal");
		bt.add(11, "shj");
		bt.add(9, "jhwl");
//		 bt.traverseBST(TraversalTypes.LEVEL_ORDER);
		bt.leftViewOfBT();
//		System.out.println(bt.findNode(100));
	}
}
