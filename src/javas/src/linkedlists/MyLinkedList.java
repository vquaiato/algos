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

    if (this.tail == null)
      this.tail = node;
  }

  public void tailAdd(Object data) {
    ListNode node = new ListNode(data);
    if (this.tail == null)
      this.tail = this.head = node;
    else {
      this.tail.next = node;
      this.tail = node;
    }
  }

  public Object removeHead() {
    var data = this.head.data;
    this.head = this.head.next;
    return data;
  }

  public Boolean isEmpty(){
    return this.head == null;
  }

  public void print() {
    var node = this.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }
}