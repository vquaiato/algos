// From Cracking the code interview
// 4.5 Check if a BTree is a valid BST

package trees;

public class CheckBST {
  public boolean check(TreeNode root) {
    return check(root, null, null);
  }

  public boolean check(TreeNode node, Integer min, Integer max) {
    if (node == null)
      return true;

    int val = node.value;
    if (min!=null && val <= min) return false;
    if (max!=null && val >= max) return false;

    if(!check(node.right, val, max)) return false;
    if(!check(node.left, min, val)) return false;

    return true;
  }

  public static void main(String[] args) {
    var root = new TreeNode(1);
    var l = new TreeNode(1);
    // l.left = new TreeNode(3);
    // l.right = new TreeNode(7);
    root.left = l;

    // var r = new TreeNode(3);
    // r.left = new TreeNode(11);
    // r.right = new TreeNode(20);
    // root.right = r;

    System.out.println(new CheckBST().check(root));
  }
}