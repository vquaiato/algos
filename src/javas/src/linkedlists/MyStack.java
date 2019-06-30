package linkedlists;

public class MyStack {
  MyLinkedList list;

  public MyStack() {
    this.list = new MyLinkedList();
  }

  public Boolean isEmpty() {
    return this.list.isEmpty();
  }

  public void push(Object data) {
    this.list.add(data);
  }

  public Object pop() {
    if (!this.isEmpty())
      return this.list.removeHead().toString();

    return null;
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    for(int i=1;i<=10;i++)
      stack.push(i);

    while (!stack.isEmpty()){
      System.out.print(stack.pop());
    }
  }
}