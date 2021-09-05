import java.util.Scanner;


public class GetMinFromStack {
  public static void main(String args[]) {
    Scanner inputScanner = new Scanner(System.in);
    int requiredNoOfOperations = inputScanner.nextInt();  //Total number of Push/Pop/Get Minimum elements Operations required
    Stack stack = new Stack();
    while (requiredNoOfOperations > 0) {
      int operationType = inputScanner.nextInt();
      if (operationType == 1) {  //OperationType equals 1 means, push an element on top of the stack
        int value = inputScanner.nextInt();
        stack.push(value);
        System.out.println(value+" Pushed on top of Stack");
      } else if (operationType == 2) { //OperationType equals 2 means, Pop an element from top of the stack, and print it
        System.out.println("Popped Element: "+stack.pop() + " ");
      } else if (operationType == 3) {  //OperationType equals 3, means get the minimum element from stack in O(1) Time
        System.out.println("Minimum Element: "+stack.getMin() + " ");
      }
      requiredNoOfOperations--;
    }
    System.out.println();
  }
}

class Element {
  int data;
  int min_till_now;
  Element next;

  Element(int data, Element next, int min_till_now) {
    this.data = data;
    this.next = next;
    this.min_till_now = min_till_now;
  }
}

class Stack {
  Element top = null;
  int size = 0;

  /*returns min element from stack in O(1) Time*/
  int getMin() {
    if (size == 0) {
      return -1;
    }
    return top.min_till_now;
  }

  /*returns poped element from stack*/
  int pop() {
    if (size == 0) {
      return -1;
    }
    int topData = top.data;
    top = top.next;
    size--;
    return topData;
  }

  /*push element x into the stack*/
  void push(int x) {
    size++;
    if (top == null) {
      top = new Element(x, null, x);
    } else {
      if (x < getMin()) {
        top = new Element(x, top, x);
      } else {
        top = new Element(x, top, getMin());
      }
    }
    // Your code here
  }
}

