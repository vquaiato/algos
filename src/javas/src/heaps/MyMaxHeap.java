package heaps;

public class MyMaxHeap{
  int[] data;
  int size = Integer.MIN_VALUE;

  public MyMaxHeap() {
    data = new int[10];
  }
  
  public Boolean isEmpty(){ return size == Integer.MIN_VALUE; }
  public int peek() throws Exception {
    if(isEmpty())
      throw new Exception("Heap is empty!");

    return data[0];
  }
  public void add(int value){
    if(isEmpty()) 
      size = 0;
    
    data[size] = value;
    size++;
    
    heapifyUpwards();
  }
  public int remove() throws Exception {
    if(isEmpty()) 
      throw new Exception("Heap is empty!");

    int value = data[0];
    data[0] = data[size-1];
    size--;

    heapifyDownwards();

    return value;
  }
  private void heapifyUpwards(){
    int currentIndex = size - 1;
    int parentIndex = (currentIndex - 1) / 2;

    while(parentIndex >= 0 && data[parentIndex] < data[currentIndex])
    {
      int temp = data[currentIndex];
      data[currentIndex] = data[parentIndex];
      data[parentIndex] = temp;

      currentIndex = parentIndex;
      parentIndex = (parentIndex - 1) / 2;
    }
  }
  private void heapifyDownwards(){
    int currentIndex = 0;
    int leftIndex = (currentIndex * 2) + 1;

    while(leftIndex < size){
      int greater = leftIndex;
      int rightIndex = (currentIndex * 2) + 2;

      if(rightIndex<size && data[rightIndex] > data[leftIndex])
        greater = rightIndex;

      if(data[currentIndex] > data[greater])
        break;
      
      int temp = data[currentIndex];
      data[currentIndex] = data[greater];
      data[greater] = temp;

      currentIndex = greater;
      leftIndex = (currentIndex * 2) + 1;
    }
  }
  
  public void printHeap(){
    for(int i=0;i<size;i++)
      System.out.print(data[i] + " ");

    System.out.println("");
  }

  public static void main(String[] args) throws Exception {
    MyMaxHeap minHeap = new MyMaxHeap();
    minHeap.add(10);
    minHeap.add(2);
    minHeap.add(5);
    minHeap.add(6);
    minHeap.add(3);
    minHeap.add(1);

    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();

    minHeap.remove();
    minHeap.printHeap();
  }
}