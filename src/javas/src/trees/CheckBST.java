// From Cracking the code interview
// 4.5 Check if a BTree is a valid BST

package trees;

public class CheckBST{
  public boolean check(TreeNode root){
    return checkLeft(root.left, root.value) &&
            checkRight(root.right, root.value);
  }
  private boolean checkLeft(TreeNode node, int min){
    if(node == null) return true;
    
    return node.value < min && 
            checkLeft(node.left, node.value) &&
            checkRight(node.right, node.value);
  }
  private boolean checkRight(TreeNode node, int max){
    if(node == null) return true;

    return node.value > max && 
            checkLeft(node.left, node.value) &&
            checkRight(node.right, node.value);
  }

  public static void main(String[] args) {
    var root = new TreeNode(10);
    var l = new TreeNode(5);
    l.left = new TreeNode(3);
    l.right = new TreeNode(7);
    root.left = l;

    var r = new TreeNode(12);
    r.left = new TreeNode(11);
    r.right = new TreeNode(13);
    root.right = r;

    System.out.println(new CheckBST().check(root));
  }
}