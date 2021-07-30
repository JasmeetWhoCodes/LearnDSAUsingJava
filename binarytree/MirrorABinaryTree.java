public class MirrorABinaryTree {
  public static void main(String args[]) {

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.left = new Node (4);

    System.out.println("\nOriginal binary tree: ");
    printInorder(root);

    MirrorABinaryTree mirrorABinaryTree = new MirrorABinaryTree();
    mirrorABinaryTree.mirror(root);

    System.out.println("\nMirror of original binary tree: ");
    printInorder(root);
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
  void mirror(Node node) {
    // Your code here
    if(node==null)
      return;
    Node leftSubtree = node.left;
    Node rightSubtree = node.right;
    node.left = rightSubtree;
    node.right = leftSubtree;
    mirror(node.left);
    mirror(node.right);
  }
}
