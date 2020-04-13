package linkedlists;

public class StackQueue {
  private MyStack stack1, stack2;

  public StackQueue() {
    stack1 = new MyStack();
    stack2 = new MyStack();
  }

  public void enqueu(Integer n){
    stack1.push(n);
  }

  public Integer dequeue(){
    if(stack2.isEmpty()){
      while(!stack1.isEmpty())
        stack2.push(stack1.pop());
    }

    if(stack2.isEmpty()) return null;
    
    return Integer.parseInt(stack2.pop().toString());
  }

  public static void main(String[] args){
    StackQueue sq = new StackQueue();

    for(int i=1;i<10;i++)
      sq.enqueu(i);

    Integer v = null;

    while((v=sq.dequeue())!=null){
      System.out.println(v);
    }
  }
}