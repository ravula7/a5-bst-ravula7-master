package a5;
//editing this!!

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>(); //empty left bst created -- left child
		_right = new EmptyBST<T>(); //empty right bst created -- right child
		_element = element; //element created T
	}

	// TODO: size
	@Override
	public int size(){
		int sizeOfLeft=0;
		int sizeOfRight=0;
		if(this._left !=null){
			sizeOfLeft = this._left.size();
		}
		if(this._right != null){
			sizeOfRight=this._right.size();
		}
		if(_element == null){
			return 0;
		}

		return sizeOfLeft+sizeOfRight+1;

		//System.out.print(_element+" ");
		//int size = _left+_right+1
		//return -1;
	}

	// TODO: findMin
	@Override
	public T findMin() {

//
		return null;
	}

	// TODO: findMax
	@Override
	public T findMax() {

		return null;
	}

	// TODO: contains
	@Override
	public boolean contains(T element) {

		return false;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if (element.compareTo(getElement()) > 0) { //recurse to the right because element is larger
			if (getRight().isEmpty()) { //insert the element if the right child is empty
				getRight().insert(element);
			}
			return new NonEmptyBST<T>(element); //=_right?
		}
		else if (element.compareTo(getElement()) < 0) { //recurse to the left because element is smaller
			if (getLeft().isEmpty()) { //insert the element if the left child is empty
				getLeft().insert(element);
			}
			return new NonEmptyBST<T>(element); //=left?
		}
		else if (element.compareTo(getElement()) == 0) {//recurse either way because element is same
			if (getLeft().isEmpty()) { //insert the element if the left child is empty
				getLeft().insert(element);
			}
			return new NonEmptyBST<T>(element); //=left?
		}
		return null;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {

		return null;
	}

	// TODO: printInOrderTraversal
	@Override
	public void printInOrderTraversal() {

	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {

	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {

	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {

	}

	@Override
	public int getHeight() {

		return Math.max(_left.getHeight(), _right.getHeight())+1; //add 1 because the main root's node needs to be counted too
	}


	@Override
	public BST<T> getLeft() {

		return _left;
	}

	@Override
	public BST<T> getRight() {

		return _right;
	}

	@Override
	public T getElement() {

		return _element;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

}
