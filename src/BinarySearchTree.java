public class BinarySearchTree<T> {
	private BinaryNode<Integer> root;

	// constructor
	public BinarySearchTree() {
		root = null;
	}

	public BinaryNode<Integer> getRoot() {
		return root;
	}

	public void add(int val) {
		if (root == null)
			this.root = new BinaryNode<>(val);
		else {
			addIterative(val);
			// addRcrsv(this.root, val);
		}
	}

	private void addIterative(int val) {
		BinaryNode<Integer> current = this.root;

		while ((val < current.getValue() && current.hasLeft()) || (val >= current.getValue() && current.hasRight())) {
			if (val < current.getValue())
				current = current.getLeft();
			else
				current = current.getRight();
		}

		BinaryNode<Integer> new_node = new BinaryNode<>(val);

		if (val < current.getValue())
			current.setLeft(new_node);
		else
			current.setRight(new_node);
	}

	private void addRcrsv(BinaryNode<Integer> current, int val) {
		if (val < current.getValue()) {
			if (!current.hasLeft()) {
				current.setLeft(new BinaryNode<>(val));
			} else {
				addRcrsv(current.getLeft(), val);
			}
		} else {
			if (!current.hasRight()) {
				current.setRight(new BinaryNode<>(val));
			}else {
				addRcrsv(current.getRight(), val);
			}
		}
	}

	public void print() {
		printInOrder(this.root);
		System.out.println();
	}

	public void printInOrder(BinaryNode<Integer> current) {
		if (current != null) {
			printInOrder(current.getLeft());
			System.out.print(current.getValue() + ", ");
			printInOrder(current.getRight());
		}
	}

	public void inOrder() {
		callInOrder(this.root);
	}

	private void callInOrder(BinaryNode<Integer> current) {
		if (current != null) {
			callInOrder(current.getLeft());
			System.out.print(current.getValue() + ", ");
			callInOrder(current.getRight());
		}
	}

	public void preOrder() {
		callPreOrder(this.root);
	}

	private void callPreOrder(BinaryNode<Integer> current) {
		if (current != null) {
			System.out.print(current.getValue() + ", ");
			callPreOrder(current.getLeft());
			callPreOrder(current.getRight());
		}
	}

	public void postOrder() {
		callPostOrder(this.root);
	}

	private void callPostOrder(BinaryNode<Integer> current) {
		if (current != null) {
			callPostOrder(current.getLeft());
			callPostOrder(current.getRight());
			System.out.print(current.getValue() + ", ");
		}
	}

	public boolean exists(int val) {
		return existsIterative(val);
		// return existsRcsv(this.root, val);
	}

	private boolean existsIterative(int val) {
		BinaryNode<Integer> current = this.root;
		while (current != null) {
			if (current.getValue() == val)
				return true;
			if (val < current.getValue())
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}

	private boolean existsRcrsv(BinaryNode<Integer> current, int val) {
		if (current == null)
			return false;
		if (current.getValue() == val)
			return true;
		if (val < current.getValue())
			return existsRcrsv(current.getLeft(), val);
		return existsRcrsv(current.getRight(), val);
	}

	public Integer getNode(int val) {
		return getNode(this.root, val);
	}

	private Integer getNode(BinaryNode<Integer> current, int val) {
		if (current == null)
			return null;
		if (current.getValue() == val)
			return val;
		if (val < current.getValue())
			return getNode(current.getLeft(), val);
		else
			return getNode(current.getRight(), val);
	}

	public int biggest() throws Exception {
		if (root == null) {
			throw new Exception("Tree is Empty");
		}
		return biggest(this.root).getValue();
	}

	private BinaryNode<Integer> biggest(BinaryNode<Integer> current) {
		if (!current.hasRight())
			return current;
		return biggest(current.getRight());
	}

	public int smallest() throws Exception {
		if (root == null) {
			throw new Exception("Tree is Empty");
		}
		return smallest(this.root).getValue();
	}

	private BinaryNode<Integer> smallest(BinaryNode<Integer> current) {
		while (current.hasLeft())
			current = current.getLeft();
		return current;
	}


	public int calcHeight() {
		return calcHeight(this.root);
	}

	private int calcHeight(BinaryNode<Integer> current) {
		if (current == null)
			return -1;
		else
			return Math.max(calcHeight(current.getLeft()), calcHeight(current.getRight())) + 1;
	}

	public boolean delete(int key) {

		BinaryNode<Integer> current = root;
		BinaryNode<Integer> parent = root;
		boolean isLeftChild = true;

		while (current.getValue() != key) {
			parent = current;
			if (key < current.getValue()) {
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
			if (current == null)
				return false;
		}

		if (!current.hasLeft() && !current.hasRight()) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}

		else if (!current.hasLeft()) {
			if (current == root)
				root = current.getRight();
			else if (isLeftChild)
				parent.setLeft(current.getRight());
			else
				parent.setRight(current.getRight());
		}

		else if (!current.hasRight()) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		}
		else {
			BinaryNode<Integer> successor = getSuccessor(current);

			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.setLeft(successor);
			else
				parent.setRight(successor);
			successor.setLeft(current.getLeft());
		}
		return true;
	}

	private BinaryNode<Integer> getSuccessor(BinaryNode<Integer> deleteItem) {
		BinaryNode<Integer> successor = deleteItem;
		BinaryNode<Integer> successorParent = deleteItem;
		BinaryNode<Integer> current = deleteItem.getRight();

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if (deleteItem.getRight() != successor) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(deleteItem.getRight());
		}
		return successor;
	}
}
