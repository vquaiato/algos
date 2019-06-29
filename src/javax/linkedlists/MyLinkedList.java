package javax.linkedlists;

public class MyLinkedList {
  ListNode head = null;
  ListNode tail = null;

  public MyLinkedList(ListNode first) {
    this.tail = this.head = first;
  }

  public MyLinkedList(int firstValue) {
    this(new ListNode(firstValue));
  }

  public void add(int data) {
    ListNode node = new ListNode(data, this.head);
    this.head = node;
  }

  public void tailAdd(int data) {
    ListNode node = new ListNode(data);
    this.tail.next = node;
    this.tail = node;
  }

  public void print() {
    var node = this.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList(10);

    for (int i = 11; i < 21; i++)
      list.tailAdd(i);

    list.print();
  }
}