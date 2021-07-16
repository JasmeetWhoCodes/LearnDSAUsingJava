/* GeeksForGeeks: https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
 */

public class DeleteANodeFromBST {
  Node getNode(Node root, String direction)
  {
    Node resultNode= root;
    if(direction=="left" && root.left!=null) {
      //System.out.println("Going inside get node for left node for data: "+root.data);
      resultNode = getNode(root.left, direction);
      if(root.left.left==null)
        root.left = root.left.right;
    }

    else if(direction=="right" && root.right!=null) {
      //System.out.println("Going inside get node for right node for data: " + root.data);
      resultNode = getNode(root.right, direction);
      if(root.right.right==null)
        root.right = root.right.left;
    }
    //System.out.println("Returning from get node for data: "+root.data+", resultNode: "+resultNode.data);
    return resultNode;
  }
  Node replaceNode(Node root)
  {
    //System.out.println("Going inside replace node for data: "+root.data);
    Node replacementNode=null;

    if(root.right!=null) { //Then replace it by left most node in the right
      replacementNode = getNode(root.right, "left");
      if (root.right.left == null) root.right = root.right.right;
    }
    else if(root.left!=null) { //Then replace it by the right most node in the left subtree
      replacementNode = getNode(root.left, "right");
      if (root.left.right == null) root.left = root.left.left;
    }
    else
      replacementNode= null;
    if(replacementNode!=null) { // Means the node the replaced by some other node in left or right subtree
      replacementNode.left=root.left;
      replacementNode.right=root.right;
    }
    //if(replacementNode!=null)
    //  System.out.println("Inside replace node: "+root.data+", Now returning: "+replacementNode.data);
    //else
    //  System.out.println("Inside replace node: "+root.data+", Now returning: null");
    return replacementNode;

  }

  Node deleteNode(Node root, int valueToBeDeleted) {
    //System.out.println("Going inside delete node for data: "+root.data);
    if (root != null) {
      if (root.data > valueToBeDeleted) //Delete in the left subtree
      {
        //System.out.println("Going inside delete node left subtree of: "+root.data);
        root.left = deleteNode(root.left, valueToBeDeleted);
      } else if (root.data < valueToBeDeleted) // Delete in the right subtree
      {
        //System.out.println("Going inside delete node right subtree of: "+root.data);
        root.right = deleteNode(root.right, valueToBeDeleted);
      } else { //Delete the current node from the tree
        root = replaceNode(root); //To delete, we have to replace it by left most node in the right subtree
      }
    }
    return root;
  }
  //DRIVER CODE HELPER FUNCTION
  public static void printInorder(Node node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.data + " ");
      printInorder(node.right);
    }
  }

  //DRIVER CODE MAIN FUNCTION
  public static void main(String args[]) {
    Node leftNode = new Node(1);
    Node rightNode = new Node(4);
    Node root = new Node(3, leftNode, rightNode);
    System.out.println("\nNormal binary tree BEFORE deletion in binary search tree: ");
    printInorder(root);
    System.out.println("\n");

    DeleteANodeFromBST deleteANodeFromBST = new DeleteANodeFromBST();
    root = deleteANodeFromBST.deleteNode(root, 3);
    System.out.println("Normal binary tree AFTER deletion in binary search tree: ");
    printInorder(root);
    System.out.println("\n");
  }

}
