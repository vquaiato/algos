// https://leetcode.com/problems/merge-k-sorted-lists/
package linkedlists;

import java.util.PriorityQueue;

class LNode {
  int val;
  LNode next;
  LNode(int x) { val = x; }
}
public class MergeKLists {
  public LNode merge(LNode[] lists){
    if(lists == null || lists.length == 0) return null;
        
      PriorityQueue<LNode> heap = new PriorityQueue<>(lists.length, (a, b) -> a.val > b.val ? -1 : 1);
      for(LNode l : lists){
        while(l!=null){
          heap.add(l);
          l = l.next;
        }
      }

      LNode tail = heap.poll();
      if(tail!=null){
        tail.next = null;
        while(!heap.isEmpty())
        {
          LNode h = heap.poll();
          h.next = tail;
          tail = h;
        }
      }

      return tail;
  }
public static void main(String[] args) {
  LNode l1 = new LNode(1);
  l1.next = new LNode(2);
  l1.next.next = new LNode(4);
  l1.next.next.next = new LNode(5);
  l1.next.next.next.next = new LNode(6);

  LNode l2 = new LNode(1);
  l2.next = new LNode(3);
  l2.next.next = new LNode(10);

  LNode l3 = new LNode(7);
  l3.next = new LNode(9);
  l3.next.next = new LNode(14);

  LNode[] input = {l2, l3, l1};

  LNode res = new MergeKLists().merge(input);
  while (res != null) {
    System.out.println(res.val);
    res = res.next;
  }
}
}