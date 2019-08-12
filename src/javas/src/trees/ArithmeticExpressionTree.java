package trees;

class ExpressionNode {
  String value;
  ExpressionNode left;
  ExpressionNode right;

  public ExpressionNode(String value) {
    this.value = value;
  }
}

public class ArithmeticExpressionTree {
  public void traverse(ExpressionNode root) {
    if (root == null)
      return;

    boolean hasLesserPrecedence = precedence(root) > precedence(root.left);
    if (hasLesserPrecedence)
      System.out.print("(");
    traverse(root.left);
    if (hasLesserPrecedence)
      System.out.print(")");

    System.out.print(root.value);

    hasLesserPrecedence = precedence(root) >= precedence(root.right);
    if (hasLesserPrecedence)
      System.out.print("(");
    traverse(root.right);
    if (hasLesserPrecedence)
      System.out.print(")");
  }

  public int precedence(ExpressionNode node) {
    if (node == null)
      return 4;

    switch (node.value) {
    case "+":
    case "-":
      return 1;
    case "/":
    case "*":
      return 2;
    default:
      return 3;
    }
  }

  public static void main(String[] args) {
    ExpressionNode root = new ExpressionNode("*");
    ExpressionNode left = new ExpressionNode("+");
    left.left = new ExpressionNode("2");
    left.right = new ExpressionNode("2");

    ExpressionNode right = new ExpressionNode("-");
    right.left = new ExpressionNode("1");
    right.right = new ExpressionNode("1");

    root.left = left;
    root.right = right;

    new ArithmeticExpressionTree().traverse(root);
  }
}