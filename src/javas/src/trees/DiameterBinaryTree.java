// https://leetcode.com/problems/diameter-of-binary-tree

package trees;

public class DiameterBinaryTree{
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
      height(root);
      return max;
  }
  private int height(TreeNode node){
      if(node == null) return 0;
      
      int left = height(node.left);
      int right = height(node.right);
      
      max = Math.max(max, left + right);
      return Math.max(left, right) + 1;
  }
}