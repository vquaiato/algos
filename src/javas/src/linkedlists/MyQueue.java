package linkedlists;

public class MyQueue {
  MyLinkedList list;

  public MyQueue() {
    this.list = new MyLinkedList();
  }

  public Boolean isEmpty() {
    return this.list.isEmpty();
  }

  public void enqueue(Object item) {
    this.list.tailAdd(item);
  }

  public Object dequeue() {
    if (!this.isEmpty())
      return this.list.removeHead();

    return null;
  }

  public static void main(String[] args) {
    MyQueue q = new MyQueue();
    for (int i = 1; i <= 35; i++)
      q.enqueue(i);

    while (!q.isEmpty())
      System.out.print(q.dequeue() + " ");
  }
}