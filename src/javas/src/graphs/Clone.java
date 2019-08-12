// https://leetcode.com/problems/clone-graph/

package graphs;

import java.util.*;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
  }

  public Node(int _val, List<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
};

public class Clone {
  public Node cloneGraph(Node node) {
    if (node == null)
      return node;

    return clone(node, new HashMap<Node, Node>());
  }

  private Node clone(Node original, Map<Node, Node> clones) {
    if (clones.containsKey(original))
      return clones.get(original);

    clones.put(original, new Node(original.val, new ArrayList<>()));

    if (original.neighbors != null) {
      for (Node n : original.neighbors)
        clones.get(original).neighbors.add(clone(n, clones));
    }

    return clones.get(original);
  }

  public static void main(String[] args) {
    Node a = new Node();
    a.val = 1;

    Node b = new Node();
    b.val = 2;

    Node c = new Node();
    c.val = 3;

    Node d = new Node();
    d.val = 4;

    a.neighbors = new ArrayList<>(Arrays.asList(b, d));
    b.neighbors = new ArrayList<>(Arrays.asList(a, c));
    c.neighbors = new ArrayList<>(Arrays.asList(b, d));
    d.neighbors = new ArrayList<>(Arrays.asList(a, c));

    Node clone = new Clone().cloneGraph(a);
  }
}