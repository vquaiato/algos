package linkedlists;

public class MyLinkedList {
  ListNode head = null;
  ListNode tail = null;

  public MyLinkedList() {
  }

  public MyLinkedList(ListNode first) {
    this.tail = this.head = first;
  }

  public MyLinkedList(Object firstValue) {
    this(new ListNode(firstValue));
  }

  public void add(Object data) {
    ListNode node = new ListNode(data, this.head);
    this.head = node;
  }

  public void tailAdd(Object data) {
    ListNode node = new ListNode(data);
    this.tail.next = node;
    this.tail = node;
  }

  public Object removeHead() {
    var data = this.head.data;
    this.head = this.head.next;
    return data;
  }

  public void print() {
    var node = this.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  // public static void main(String[] args) {
  // MyLinkedList list = new MyLinkedList(10);

  // for (int i = 11; i < 21; i++)
  // list.tailAdd(i);

  // list.print();
  // }
}