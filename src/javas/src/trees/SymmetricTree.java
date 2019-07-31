// https://leetcode.com/problems/symmetric-tree/

package trees;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    postOrder(root.right, list);
    preOrder(root.left, list);

    int i = 0, j = list.size() - 1;
    while (i < j) {
      if (list.get(i) != list.get(j))
        return false;

      i++;
      j--;
    }

    return true;
  }

  private void postOrder(TreeNode node, List<Integer> list) {
    if (node == null) {
      list.add(null);
      return;
    }

    if (node.left == null && node.right == null) {
      list.add(node.value);
      return;
    }
    postOrder(node.left, list);
    postOrder(node.right, list);
    list.add(node.value);
  }

  private void preOrder(TreeNode node, List<Integer> list) {
    if (node == null) {
      list.add(null);
      return;
    }

    list.add(node.value);
    if (node.left == null && node.right == null)
      return;

    preOrder(node.left, list);
    preOrder(node.right, list);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    left.left = new TreeNode(3);
    left.right = new TreeNode(4);
    root.left = left;

    TreeNode right = new TreeNode(2);
    right.left = new TreeNode(4);
    right.right = new TreeNode(3);
    root.right = right;

    System.out.println(new SymmetricTree().isSymmetric(root));
  }
}