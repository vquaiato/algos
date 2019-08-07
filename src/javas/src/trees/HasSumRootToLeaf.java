// https://leetcode.com/problems/path-sum/

package trees;

public class HasSumRootToLeaf {
  public boolean hasPathSum(TreeNode root, int sum) {
    return traversal(root, sum, 0);
  }

  private boolean traversal(TreeNode node, int sum, int currentSum) {
    if (node == null) return false;

    currentSum += node.value;

    if (node.isLeaf()) return currentSum == sum;

    return traversal(node.left, sum, currentSum) || traversal(node.right, sum, currentSum);
  }
}