package linkedlists;

class Node {
  int val;
  Node next;

  Node(int x) {
    val = x;
  }
}

public class ReverseLinkedList {
  public Node reverseList(Node head) {
    if(head == null) return null;
    if (head.next == null) return head;

    Node n = reverseList(head.next);
    head.next.next = head;
    head.next = null;

    return n;
  }

  public static void main(String[] args) {
    Node h = new Node(1);
    h.next = new Node(2);
    h.next.next = new Node(3);
    h.next.next.next = new Node(4);
    h.next.next.next.next = new Node(5);

    Node rev = new ReverseLinkedList().reverseList(h);
    while(rev!=null)
    {
      System.out.print(rev.val + "->");
      rev = rev.next;
    }
    System.out.print("NULL");
  }
}