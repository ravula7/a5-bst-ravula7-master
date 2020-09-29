package a5;


public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(3); //constructor --> this is what we are writing methods for
     /* bst = bst.insert(8);
      bst = bst.insert(1);
      bst = bst.insert(9);
      bst = bst.insert(4);
      bst = bst.remove(3);
      bst.printBreadthFirstTraversal();
      check to see if requested element is in the tree
      if it is not, it removes whatever is just less than that element which shouldn't happen

      */
     System.out.println(bst.size());


  }

}
