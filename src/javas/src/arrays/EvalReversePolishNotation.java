// https://leetcode.com/problems/evaluate-reverse-polish-notation/

package arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalReversePolishNotation {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0)
      return 0;

    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {
      if (!"+-*/".contains(token))
        stack.addFirst(Integer.parseInt(token));
      else
        stack.addFirst(calc(token, stack.pop(), stack.pop()));
    }

    return stack.pop();
  }

  private int calc(String op, int operand1, int operand2) {
    switch (op) {
    case "+":
      return operand2 + operand1;
    case "-":
      return operand2 - operand1;
    case "/":
      return operand2 / operand1;
    default:
      return operand2 * operand1;
    }
  }

  public static void main(String[] args) {
    String[] tokens = {"2"};
    // String[] tokens = {"2", "1", "+", "3", "*"};
    // String[] tokens = {"4", "13", "5", "/", "+"};
    // String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

    System.out.println(new EvalReversePolishNotation().evalRPN(tokens));
  }
}