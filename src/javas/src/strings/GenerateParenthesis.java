// https://leetcode.com/problems/generate-parentheses/

package strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  public List<String> generateParenthesis(int k) {
    StringBuilder curr = new StringBuilder();
    int open = k, close = k;
    List<String> res = new ArrayList<>();

    generate(res, open, close, curr, k);

    return res;
  }

  //backtracking
  private void generate(List<String> res, int open, int close, StringBuilder curr, int k) {
    if (open == 0 && close == 0) {
      res.add(curr.toString());
      return;
    }

    if (open > 0) {
      curr.append("(");
      generate(res, open - 1, close, curr, k);
      curr.deleteCharAt(curr.length() - 1);
    }
    if (close > 0 && close > open) {
      curr.append(")");
      generate(res, open, close - 1, curr, k);
      curr.deleteCharAt(curr.length() - 1);
    }
  }

  public static void main(String[] args) {
    int k = 2;
    System.out.println(new GenerateParenthesis().generateParenthesis(k));
  }
}