package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TreeIterator implements Iterator<TreeNode> {
  Deque<TreeNode> stack;

  public TreeIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    stack.addFirst(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public TreeNode next() {
    TreeNode next = stack.pop();
    if (next.right != null)
      stack.addFirst(next.right);

    if (next.left != null)
      stack.addFirst(next.left);

    return next;
  }

  public static void main(String[] args) {
    TreeNode tree = new CodecTree().deserialize("1,2,3,n,n,4,5");

    TreeIterator it = new TreeIterator(tree);
    while(it.hasNext())
      System.out.println(it.next().value);
  }
}