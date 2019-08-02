// https://leetcode.com/problems/decode-string/

package strings;

import java.util.*;

public class DecodeString {
  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if (c == ']') {
        String x = stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!Character.isDigit(x.charAt(0))) {
          if (!x.equals("["))
            sb.append(x);

          if (!stack.isEmpty())
            x = stack.pop();
        }

        String number = x;
        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)))
          number = stack.pop() + number;

        int num = Integer.parseInt(number);

        StringBuilder sbm = new StringBuilder(sb.length() * num);
        for (int i = 0; i < num; i++)
          sbm.append(sb.toString());

        stack.add(sbm.toString());
        sbm = sb = null;
      } else
        stack.add(c.toString());
    }

    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty())
      res.append(stack.pop());

    return res.reverse().toString();
  }

  public static void main(String[] args) {
    String input = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
    System.out.println(new DecodeString().decodeString(input));
  }
}