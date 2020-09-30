package a5;


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
		if (element.compareTo(_element) >= 0) { //recurse to the right because element is larger or the same
			_right = _right.insert(element);
		}
		else if (element.compareTo(_element) < 0) { //recurse to the left because element is smaller
			_left = _left.insert(element);
		}
		return this;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if(_right.isEmpty()){
			_right = _right.remove(element);
		}
		else if(_left.isEmpty()){
			_left = _left.remove(element);
		}
		return this;
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
