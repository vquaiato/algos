// Cracking the code interview
// 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
// write an algo­rithm to create a binary search tree with minimal height.
// eg. [1,2,3,4,5,6]
//         4
//       /  \
//      3    5
//    /  \    \
//   1    2    6

package trees;

public class MinimalBST{
  public TreeNode create(int[] arr){
    return create(arr, 0, arr.length - 1);
  }
  private TreeNode create(int[] arr, int i, int j){
    if(j < i) return null;

    int mid = (i+j)/2;

    TreeNode n = new TreeNode(arr[mid]);
    n.left = create(arr, i, mid-1);
    n.right = create(arr, mid+1, j);

    return n;
  }

  public static void main(String[] args) {
    int[] input = {1,2,3,4,5,6};
    TreeNode root = new MinimalBST().create(input);

    inorderPrint(root);
  }
  private static void inorderPrint(TreeNode node){
    if(node!=null){
      inorderPrint(node.left);
      System.out.println(node.value);
      inorderPrint(node.right);
    }
  }
}