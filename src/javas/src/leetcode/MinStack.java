package leetcode;

class MyNode{
  int data;
  MyNode next;
  
  public MyNode(int data){
    this.data = data;
    this.next = null;
  }
}

public class MinStack {
    MyNode head;
    MyNode mins;
  
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
      MyNode n = new MyNode(x);
      if(this.head == null)
        this.head = n;
      else{
        n.next = this.head;
        this.head = n;
      }

      if(this.mins == null || this.mins.data >= n.data)
      {
        MyNode nMin = new MyNode(x);
        nMin.next = this.mins;
        this.mins = nMin;
      }
    }
    
    public void pop() {
      if(this.head == null)
        throw new RuntimeException("Stack Underflow");
      
      if(this.head.data == this.mins.data)
      {
        MyNode nextMin = this.mins.next;
        this.mins = nextMin;
      }
      
      this.head = this.head.next;
    }
    
    public int top() {
      if(this.head == null)
        throw new RuntimeException("Stack Underflow");
      
        return this.head.data;
    }
    
    public int getMin() {
      if(this.head == null)
        throw new RuntimeException("Stack Underflow");
      
        return this.mins.data;
    }

    public static void main(String[] args){
      MinStack m = new MinStack();
      m.push(10);
      m.push(1);
      m.push(5);

      System.out.println("Top: "  + m.top());
      System.out.println("Min: "  + m.getMin());
    }
}