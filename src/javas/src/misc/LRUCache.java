package misc;

import java.util.HashMap;

class DLNode {
  DLNode prev;
  int value;
  int key;
  DLNode next;
  public DLNode(int value, int key) {
    this.value = value;
    this.key = key;
  }
  public DLNode() {  }
}
public class LRUCache {
  int maxCapacity = 0, currentCapacity = 0;
  DLNode head, tail;
  HashMap<Integer, DLNode> hash = new HashMap<Integer, DLNode>();;

  public LRUCache(int capacity) {
    this.maxCapacity = capacity;
    this.head = new DLNode(); this.tail = new DLNode();

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public void put(int key, int value){
    DLNode n = hash.get(key);
    if(n == null){
      n = new DLNode(value, key);
      moveToFront(n);
      this.hash.put(key, n);
      this.currentCapacity++;
      evictLastIfNeeded();
    }
    else{
      n.value = value;
      n.prev.next = n.next;
      n.next.prev = n.prev;
      moveToFront(n);
    }
  }

  public void moveToFront(DLNode n){
    n.prev = this.head;
    n.next = this.head.next;
    
    this.head.next.prev = n;
    this.head.next = n;
  }
  private void evictLastIfNeeded(){
    if(currentCapacity>maxCapacity){
      DLNode deleteNode = this.tail.prev;
      deleteNode.prev.next = this.tail;
      this.tail.prev = deleteNode.prev;

      this.hash.remove(deleteNode.key);
      deleteNode = null;
    }
  }
  int NOT_FOUND = -1;
  public int get(int key){
    DLNode n = hash.get(key);
    if(n == null) return NOT_FOUND;

    put(n.key, n.value);
    return n.value;
  }
  public static void main (String[] args){
    LRUCache c = new LRUCache(10);
    c.put(1, 1);
    c.put(2, 2);
    c.get(1);
    c.put(3, 3);
    c.put(1, 10);
    c.get(1);
  }
}