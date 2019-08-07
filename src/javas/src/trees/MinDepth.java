//https://leetcode.com/problems/minimum-depth-of-binary-tree/

package trees;

public class MinDepth {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;

    int left = minDepth(root.left) + 1;
    int right = minDepth(root.right) + 1;

    if (left > 1 && right > 1)
      return Math.min(left, right);

    return Math.max(left, right);
  }

}