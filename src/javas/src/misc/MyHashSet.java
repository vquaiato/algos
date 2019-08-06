// https://leetcode.com/problems/design-hashset/

package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class HashItem{
  int key;

  public HashItem() {  }
  public HashItem(int key) { this.key = key; }
}
// hashing
class MyHashSet {
  private int growthFactor = 1;
  private final double loadFactor = 0.7;
  private int capacity = 16;
  private List<LinkedList<HashItem>> map = null;
  private int items = 0;

  public MyHashSet() { resizeMap(); }
  public MyHashSet(int initialCapacity) { capacity = initialCapacity; resizeMap(); }
  private void resizeMap() { 
    map = new ArrayList<>(capacity);
    for(int i=0;i<capacity;i++)
      map.add(new LinkedList<>());
  }
  private int hash(int key){ return key % capacity; }
  private void reHashIfNeeded(){
    if((double)items / (double)capacity < loadFactor)
      return;

      capacity *= (growthFactor *= 2);

    List<LinkedList<HashItem>> nMap = map;
    resizeMap();
    items = 0;
    for(LinkedList<HashItem> l : nMap)
      for(HashItem n : l)
        put(n.key);
  }

  public void put(int key){
    int hash = hash(key);

    LinkedList<HashItem> hashedItems = map.get(hash);

    for(HashItem n : hashedItems)
      if(n.key == key) return;

    items++;
    hashedItems.add(new HashItem(key));

    reHashIfNeeded();
  }
  public boolean contains(int key){
    LinkedList<HashItem> hashedItems = map.get(hash(key));
    for(HashItem n : hashedItems)
      if(n.key == key)
        return true;

    return false;
  }
  public void remove(int key){ 
    LinkedList<HashItem> hashedItems = map.get(hash(key));

      for(HashItem n : hashedItems)
        if(n.key == key){
          hashedItems.remove(n);
          items--;
          return;
        }
  }
  public int size(){return items;}

  public static void main(String[] args) {
    MyHashSet hashMap = new MyHashSet();
    hashMap.put(17);
    hashMap.put(7);
    hashMap.put(1);
    System.out.println(hashMap.contains(17));
    System.out.println(hashMap.contains(7));
    hashMap.remove(7);
    System.out.println(hashMap.contains(17));
    System.out.println(hashMap.contains(7));
    for(int i=10;i<100;i++)
      hashMap.put(i);
  }
}