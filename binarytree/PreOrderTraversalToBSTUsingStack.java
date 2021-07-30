import java.util.Stack;


public class PreOrderTraversalToBSTUsingStack {
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
  public static Node constructTree(int pre[], int size)   //O(N) worst case complexity
  {
    Node root= new Node(pre[0]);
    Stack<Node> stack = new Stack<>();
    stack.add(root);
    for(int i=1;i<size;i++)
    {
      Node temp=null;
      while(stack.size()>0 && stack.peek().data < pre[i])
      {
        temp = stack.pop();
      }
      if(temp!=null) {
        temp.right = new Node(pre[i]);
        stack.push(temp.right);
      }
      else
      {
        stack.peek().left = new Node(pre[i]);
        stack.push(stack.peek().left);
      }
    }
    return root;
  }
}
