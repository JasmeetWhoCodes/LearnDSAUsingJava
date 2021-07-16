import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
  Node(int data, Node left, Node right)
  {
    this.data=data;
    this.left=left;
    this.right=right;
  }
}

class BinaryTreeToBST {
  int globalIndex = 0;
  // The given root is the root of the Binary Tree
  // Return the root of the generated BST

  void generateBinarySearchTree(Node node, List<Integer> resultList) {
    if (node != null) {
      if (node.left != null) {
        //currentIndex++; //increase the currentIndex by 1 to make the next element in list available to be read
        generateBinarySearchTree(node.left, resultList);
      }
      //Now replace the data at current position in binary tree
      node.data = resultList.get(globalIndex);
      globalIndex++;

      if (node.right != null) {
        generateBinarySearchTree(node.right, resultList);
      }
    }
  }

  void preOrderTraversalToStoreInList(Node node, List<Integer> resultList) {
    if (node != null) {
      resultList.add(node.data);
      preOrderTraversalToStoreInList(node.left, resultList);
      preOrderTraversalToStoreInList(node.right, resultList);
    }
  }

  Node binaryTreeToBST(Node root) {
    List<Integer> resultList = new ArrayList<Integer>();
    preOrderTraversalToStoreInList(root, resultList); //store the tree elements' data in a list
    Collections.sort(resultList); //Sort the list
    generateBinarySearchTree(root,
        resultList); //Replace the existing tree data elements with new data elements as specified in resultList
    return root; //because we replaced the data in the existing tree itself
  }
}

class Driver {

  public static void printInorder(Node node)
  {
    if(node!=null)
    {
      printInorder(node.left);
      System.out.print(node.data+" ");
      printInorder(node.right);
    }
  }
  public static void main(String args[]) {
    Node leftNode = new Node (1);
    Node rightNode = new Node(2);
    Node root = new Node(3,leftNode,rightNode);
    System.out.println("\nNormal binary tree BEFORE conversion to binary search tree: ");
    printInorder(root);

    BinaryTreeToBST binaryTreeToBST = new BinaryTreeToBST();
    binaryTreeToBST.binaryTreeToBST(root);
    System.out.println("\nNormal binary tree AFTER conversion to binary search tree: ");
    printInorder(root);
  }
}
