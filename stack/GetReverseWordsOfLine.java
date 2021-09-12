import java.util.Scanner;
import java.util.Stack;


public class GetReverseWordsOfLine {
  public static void main(String args[]) {
    Scanner inputScanner = new Scanner(System.in);
    String inputString; //The input String, set of words
    inputString = inputScanner.nextLine();
    ReverseWords reverseWordsObject = new ReverseWords();
    System.out.println(reverseWordsObject.reverseWords(inputString)); //Reverse the words and print the result
  }
}

class ReverseWords {
  String reverseWords(String S) {
    String output = "";
    Character temp;
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < S.length(); i++) {
      char currentChar = S.charAt(i);
      if (Character.isLetterOrDigit(currentChar)) { //If character in the string is equals to letters or digits then push into the stack
        st.push(currentChar);
      } else { //If character in the string is not equals to letters or digits then pop all the characters from stack and make the stack empty
        while (!st.empty()) {
          temp = st.pop();
          output = output.concat(Character.toString(temp)); //Appends the top character of the stack to the output string
        }
        output = output.concat(Character.toString(currentChar));  //Appends the non letter, non digit character to the output string, because these letters don't need to be replaced in output
      }
    }
    while (!st.empty()) { //Check if there are remaining characters in the stack. and appends them to output string
      temp = st.pop();
      output = output.concat(Character.toString(temp));
    }
    return output; //Return the output string
  }
}