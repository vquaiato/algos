package linkedlists;

public class MyStack {
  MyLinkedList list;

  public MyStack() {
    this.list = new MyLinkedList();
  }

  public Boolean isEmpty() {
    return this.list.head == null;
  }

  public void push(String data) {
    this.list.add(data);
  }

  public String pop() {
    if (!this.isEmpty())
      return this.list.removeHead().toString();

    return null;
  }

  // public static void main(String[] args) {
  //   MyStack stack = new MyStack();
  //   stack.push("world");
  //   stack.push("hello ");

  //   while (!stack.isEmpty()){
  //     System.out.print(stack.pop());
  //   }
  // }
}