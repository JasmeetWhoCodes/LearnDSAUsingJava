public class PreOrderTraversalToBSTUsingSimpleInsertion {
  public static void main(String args[])
  {
    int preOrderTraversalArray1[]=new int []{40,30,32,35,80,90,100,120};
    int preOrderTraversalArray2[] = new int [] {40,30,35,80,100};
    Node treeRoot1= constructTree(preOrderTraversalArray1, preOrderTraversalArray1.length);
    System.out.println("\nPrinting post order of preOrderTraversalArray1 as: ");
    printPostOrder(treeRoot1);

    Node treeRoot2= constructTree(preOrderTraversalArray2, preOrderTraversalArray2.length);
    System.out.println("\nPrinting post order of preOrderTraversalArray2 as: ");
    printPostOrder(treeRoot2);
  }
  public static void printPostOrder(Node node)
  {
    if(node!=null)
    {
      printPostOrder(node.left);
      printPostOrder(node.right);
      System.out.print(node.data+" ");
    }
  }
  public static Node insertANodeInBST(Node root, int elementToInsert)
  {
    if(root==null)
    {
      root = new Node(elementToInsert);
    }
    else if(root.data > elementToInsert)
    {
      root.left = insertANodeInBST(root.left,elementToInsert);
    }
    else
    {
      root.right = insertANodeInBST(root.right,elementToInsert);
    }
     return root;
  }
  public static Node constructTree(int pre[], int size) //O(N*N) worst case complexity
  {
    Node root= null;
    for(int i=0;i<size;i++)
      root = insertANodeInBST(root, pre[i]);
    return root;
  }
}
