// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CodecTree {
  public String serialize(TreeNode root) {
    if (root == null)
      return "n";

    StringBuilder serializedTreeBuffer = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);
    while (!q.isEmpty()) {
      TreeNode n = q.poll();

      serializedTreeBuffer.append(n == null ? "n" : n.value);
      serializedTreeBuffer.append(",");

      if (n == null)
        continue;

      q.add(n.left);
      q.add(n.right);
    }

    return serializedTreeBuffer.substring(0, serializedTreeBuffer.length() - 1);
  }

  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0 || data.equals("n"))
      return null;

    String[] nodes = data.split(",");
    if (nodes == null || nodes.length == 0)
      return null;

    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < nodes.length) {
      TreeNode n = q.poll();
      if (!nodes[i].equals("n")) {
        n.left = new TreeNode(Integer.parseInt(nodes[i]));
        q.add(n.left);
      }
      i++;
      if (!nodes[i].equals("n")) {
        n.right = new TreeNode(Integer.parseInt(nodes[i]));
        q.add(n.right);
      }
      i++;
    }

    return root;
  }

  public static void main(String[] args) {
    // String input = "1,2,3,null,null,4,5,null,null,null,null,";

    TreeNode t = new CodecTree().deserialize("5,2,3,n,n,2,4,3,1");
    String r = new CodecTree().serialize(t);
    TreeNode n = new CodecTree().deserialize(r);
  }
}