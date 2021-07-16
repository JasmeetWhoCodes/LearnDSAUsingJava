/* GeeksForGeeks: https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
 */

public class InsertANodeInBST {

  Node insert(Node root, int Key)
  {
    // If Key is not present in the BST, Insert a new Node with a value equal to Key into the BST.
    if(root!=null)
    {
      if(root.data > Key) { //Need to insert Key in the leftsubtree of current node
        root.left=insert(root.left, Key);
      }
      else if(root.data < Key) { //Need to insert Key in the RightSubtree of current node
        root.right=insert(root.right, Key);
      }
    }
    else
      root = new Node(Key);
    return root;
  }
  //DRIVER CODE HELPER FUNCTION
  public static void printInorder(Node node)
  {
    if(node!=null)
    {
      printInorder(node.left);
      System.out.print(node.data+" ");
      printInorder(node.right);
    }
  }
  //DRIVER CODE MAIN FUNCTION
  public static void main(String args[]) {
    Node leftNode = new Node (1);
    Node rightNode = new Node(4);
    Node root = new Node(3,leftNode,rightNode);
    System.out.println("\nNormal binary tree BEFORE Insertion to binary search tree: ");
    printInorder(root);

    InsertANodeInBST insertANodeInBST = new InsertANodeInBST();
    root = insertANodeInBST.insert(root, 30);
    System.out.println("\nNormal binary tree AFTER Insertion to binary search tree: ");
    printInorder(root);
  }
}
