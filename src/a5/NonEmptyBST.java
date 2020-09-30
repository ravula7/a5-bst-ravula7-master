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
	}

	// TODO: findMin
	@Override
	public T findMin() {
		T minimum =  _element;
		while(!_left.isEmpty()){
			minimum = (T) _left;
		}
		return minimum;
	}

	// TODO: findMax
	@Override
	public T findMax() {
		T maximum =  _element;
		while(!_right.isEmpty()){
			maximum = (T) _right;
		}
		return maximum;
	}

	// TODO: contains
	@Override
	public boolean contains(T element) {
		if(this.isEmpty()){ //when the tree is empty, it contains no elements
			return false;
		}
		else if(element.compareTo(_element) == 0){ //found the element!
			return true;
		}
		else if(element.compareTo(_element) > 0){ //need to recurse right to find the element
			return getRight().contains(element); //return true or false whether the right side contains the element or not
		}
		else if(element.compareTo(getElement()) < 0){ //need to recurse left to find the element
			return getLeft().contains(element); //return true or false whether the left side contains the element or not
		}
		return false; //otherwise
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
		if (element.compareTo(_element) > 0) { //recurse to the right because element is larger
			_right = _right.remove(element);
		}
		else if (element.compareTo(_element) <0) { //recurse to the left because element is smaller
			_left = _left.remove(element);
		}

		//recursing
		if(_element== null){
			return null;
		}
		if(element.compareTo(_element) <0){ //recurse to the left because element is smaller
			_left = _left.remove(element);
		}
		else if (element.compareTo(_element) > 0) { //recurse to the right because element is larger
			_right = _right.remove(element);
		}
		else {
			//two children
			/*if(_right != null && _left != null){

			}
			 */
			//one non empty child on the left
			if(_left != null){
				element = (T) _left.getLeft();
			}
			//one non empty child on the right
			else if(_right != null){
				element = (T) _right.getRight();
			}
			//no children
			else{
				element = null;
			}
		}

		/*if(_right.isEmpty()){
			_right = _right.remove(element);
		}
		else if(_left.isEmpty()){
			_left = _left.remove(element);
		}
		 */
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
