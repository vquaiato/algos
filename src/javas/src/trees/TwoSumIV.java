// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// could have done it using an array/list and a in-order traversal
// getting a sorted array/list. Then running pointers on the sorted list.

package trees;

import java.util.*;

public class TwoSumIV{
  public boolean findTarget(TreeNode root, int k){
    if(root == null) return false;
    HashSet<Integer> need = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    need.add(k - root.value);

    while(!queue.isEmpty()){
      TreeNode n = queue.poll();
      if(n == null) continue;

      if(need.contains(n.value)) return true;

      need.add(k - n.value);
      queue.add(n.left);
      queue.add(n.right);
    }

    return false;
  }
  public static void main(String[] args) {
    var root = new TreeNode(5);
    var l = new TreeNode(3);
    l.left = new TreeNode(2);
    l.right = new TreeNode(4);
    root.left = l;

    var r = new TreeNode(6);
    // r.left = new TreeNode(11);
    r.right = new TreeNode(7);
    root.right = r;

    System.out.println(new TwoSumIV().findTarget(root, 17));
  }
}