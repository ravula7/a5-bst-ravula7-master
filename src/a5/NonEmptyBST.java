package a5;

import java.util.LinkedList;
import java.util.Queue;
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
		if(!_left.isEmpty()) {
			minimum =_left.findMin();
		}
		else if(_left.isEmpty()){
			minimum = this._element;
		}
		return minimum;
	}

	// TODO: findMax
	@Override
	public T findMax() {
		T maximum =  _element;
		if(!_right.isEmpty()) {
			maximum =_right.findMax();
		}
		else if(_right.isEmpty()){
			maximum = this._element;
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
		else if(_left.isEmpty() && _right.isEmpty()){
			EmptyBST<T> emptyTree = new EmptyBST<T>();
			return emptyTree;
		}
		else if(!_left.isEmpty() && _right.isEmpty()){
			return _left;
		}
		else if(_left.isEmpty() && !_right.isEmpty()){
			return _right;
		}
		else if (!_left.isEmpty() && !_right.isEmpty()){
			T minimum = _right.findMin();
			_element = minimum;
			_right = _right.remove(minimum);
		}

		return this;
	}
	//every element takes the place of _element at some point and that is when it is printed
	// TODO: printInOrderTraversal
	@Override
	//visit left, root, right
	public void printInOrderTraversal() { //void so use system.out.print
		if(_left == null && _right ==null) { //nothing left to traverse - then return nothing
			return;
		}
		_left.printInOrderTraversal(); //recurse left
		System.out.print(_element + " "); //print the root
		_right.printInOrderTraversal(); //recurse right
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if(_left == null && _right ==null) { //nothing left to traverse - then return nothing
			return;
		}
		System.out.print(_element + " "); //print the root
		_left.printPreOrderTraversal(); //recurse left
		_right.printPreOrderTraversal(); //recurse right
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if(_left == null && _right ==null) { //nothing left to traverse - then return nothing
			return;
		}
		_left.printPostOrderTraversal(); //recurse left
		_right.printPostOrderTraversal(); //recurse right
		System.out.print(_element + " "); //print the root
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		Queue <BST<T>> queue = new LinkedList<BST<T>> () ;
		queue.add((BST<T>) _element);
		while(!queue.isEmpty()){
		BST<T> node = queue.remove();
		System.out.print(node +" ");
			if(!node.getLeft().isEmpty()){
			queue.add(node.getLeft());
			}
			if(!node.getRight().isEmpty()){
			queue.add(node.getRight());
			}
		}
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
