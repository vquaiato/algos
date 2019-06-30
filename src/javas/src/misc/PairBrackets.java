package misc;
import linkedlists.*;

public class PairBrackets {
  private static String correctPair(String fromStack){
    switch(fromStack){
      case "{": return "}";
      case "[": return "]";
      case "(": return ")";
      default: return "";
    }
  }
  public static Boolean matches(String exp) {
    MyStack stack = new MyStack();
    char[] expToChars = exp.toCharArray();

    for (Character c : expToChars) {
      if (c == '{' || c == '[' || c == '(')
        stack.push(c.toString());
      else if (c == '}' || c == ']' || c == ')') {
        var item = stack.pop();
    
        if (!c.toString().equalsIgnoreCase(correctPair(item.toString())))
          return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String exp = "{1+2[(5+$)]]}";

    System.out.println("Should be false: " + matches(exp));
  }
}