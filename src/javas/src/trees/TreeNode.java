package trees;

public class TreeNode {
  TreeNode left;
  TreeNode right;
  int value;

  public TreeNode() {
  }
  public TreeNode(int value) {
    this.value = value;
    this.left = this.right = null;
  }

  boolean isLeaf() {return this.left == null && this.right == null;}
}