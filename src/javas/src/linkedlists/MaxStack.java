// https://leetcode.com/problems/min-stack/

package linkedlists;


class MaxStack {
  class MyNode{
    int data;
    MyNode next;
    
    public MyNode(int data){
      this.data = data;
      this.next = null;
    }
  }
  MyNode head;
  MyNode maxs;

  public MaxStack() { }
  
  public void push(int x) {
    MyNode n = new MyNode(x);
    if(this.head == null)
      this.head = n;
    else{
      n.next = this.head;
      this.head = n;
    }

    int max = this.maxs == null ? n.data : Math.max(this.maxs.data, n.data);
    MyNode nMax = new MyNode(max);

    if(this.maxs == null)
      this.maxs = nMax;
    else {
      nMax.next = this.maxs;
      this.maxs = nMax;
    }
  }
  
  public int pop() {
    if(this.head == null)
      throw new RuntimeException("Stack Underflow");
    
    this.maxs = this.maxs.next;

    int v = this.head.data;
    this.head = this.head.next;

    return v;
  }
  
  public int top() {
    if(this.head == null)
      throw new RuntimeException("Stack is empty");
    
      return this.head.data;
  }
  public int peekMax(){
    if(this.maxs == null)
      throw new RuntimeException("Stack is empty");

    return this.maxs.data;
  }
  
  public int popMax() {
    if(this.maxs == null)
      throw new RuntimeException("Stack is empty");
    
      MyNode temp = null;
      while(this.head.data != this.maxs.data){
        MyNode n = new MyNode(this.head.data);
        n.next = temp;
        temp = n;
        pop();
      }
      
      int max = pop();
      
      while(temp!=null){
        push(temp.data);
        temp = temp.next;
      }

      return max;
  }

  public static void main(String[] args){
    MaxStack m = new MaxStack();
    m.push(5);
    m.push(1);
    m.push(-5);
    

    System.out.println("PopMax: "  + m.popMax());
    System.out.println("PopMax: "  + m.popMax());
    System.out.println("Top: "  + m.top());
  }
}