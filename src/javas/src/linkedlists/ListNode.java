package linkedlists;

public class ListNode {
  public Object data;
  public ListNode next;

  public ListNode(Object data) {
    this.data = data;
  }

  public ListNode(Object data, ListNode next) {
    this(data);
    this.next = next;
  }
}