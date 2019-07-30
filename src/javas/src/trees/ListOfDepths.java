// from Cracking the code interview

// 4.3: Given a binary tree, design an algorithm
// which creates a linked list of all the nodes at each depth
// (eg. if you have a tree with depth D, you'll have D linked lists).

package trees;

import java.util.*;

import linkedlists.ListNode;

public class ListOfDepths{
    public List<ListNode> listFrom(TreeNode root){
      List<ListNode> res = new ArrayList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      
      int level = 0, visited = 0;

      ListNode h = null, t = null;
      while(!queue.isEmpty()){
        var node = queue.poll();
        if(node == null) continue;

        visited++;
        var item = new ListNode(node.value);

        if(level == 0){
          res.add(item);
          level++;
          visited=0;
        }
        else if(visited == level*2){
          t.next = item;
          res.add(h);
          h = null;
          level++; visited=0;
        }
        else
        {
          if(h == null)
            h = t = item;
          else{
            t.next = item;
            t = t.next;
          }
        }
          
        queue.add(node.left);
        queue.add(node.right);
      }

      return res;
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

      var res = new ListOfDepths().listFrom(root);

      for (var h : res) {
        while(h!=null){
          System.out.print(h.data + " -> ");
          h = h.next;
        }
        System.out.println("");
      }
    }
}