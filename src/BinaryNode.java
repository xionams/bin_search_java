public class BinaryNode<T> {
	private BinaryNode<T> left;
	private T value;
	private BinaryNode<T> right;

	public BinaryNode(BinaryNode<T> left, T value, BinaryNode<T> right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public BinaryNode(T value) {
		this.value = value;
		this.right = null;
		this.left = null;
	}

	public boolean hasLeft() {
		// hasLeft(): return true if the node has left child
		return (this.left != null);
	}

	public BinaryNode<T> getLeft() {
		// getLeft(): return the left child
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		// setLeft(): create a new left child
		this.left = left;
	}

	public T getValue() {
		// getValue(): return the value of the node(the key)
		return value;
	}

	public void setValue(T value) {
		// setValue(): update the value of the node
		this.value = value;
	}

	public boolean hasRight() {
		// hasRight(): return true if the node has left child
		return (this.right != null);
	}

	public BinaryNode<T> getRight() {
		// getRight: return the left child
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		// setRight(): create a new left child
		this.right = right;
	}
}