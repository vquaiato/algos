// https://leetcode.com/problems/design-hashmap/

package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// brute force
public class MyHashMap {
  int[] map = new int[1000000];

  public MyHashMap() {
    Arrays.fill(map, -1);
  }

  public void put(int key, int value) {
    map[key] = value;
  }

  public int get(int key) {
    return map[key];
  }

  public void remove(int key) {
    map[key] = -1;
  }
}

class MapNode{
  int key;
  int value;

  public MapNode() {  }
  public MapNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
// hashing
class MyGoodHashMap {
  private final double loadFactor = 0.8;
  private int capacity = 8;
  private List<LinkedList<MapNode>> map = null;
  private int items = 0;

  public MyGoodHashMap() { resizeMap(); }
  public MyGoodHashMap(int initialCapacity) { capacity = initialCapacity; resizeMap(); }
  private void resizeMap() { 
    map = new ArrayList<>(capacity);
    for(int i=0;i<capacity;i++)
      map.add(new LinkedList<>());
  }
  private int hash(int key){ return key % capacity; }
  private void reHashIfNeeded(){
    if((double)items / (double)capacity < loadFactor)
      return;

    capacity *= 2;

    List<LinkedList<MapNode>> nMap = map;
    resizeMap();
    items = 0;
    for(LinkedList<MapNode> l : nMap)
      for(MapNode n : l)
        put(n.key, n.value);
  }

  public void put(int key, int value){
    int hash = hash(key);

    LinkedList<MapNode> hashedItems = map.get(hash);

    for(MapNode n : hashedItems)
      if(n.key == key){
        n.value = value;
        return;
      }

    items++;
    hashedItems.add(new MapNode(key, value));

    reHashIfNeeded();
  }
  public int get(int key){
    LinkedList<MapNode> hashedItems = map.get(hash(key));
    for(MapNode n : hashedItems)
      if(n.key == key)
        return n.value;

    return -1;
  }
  public void remove(int key){ 
    LinkedList<MapNode> hashedItems = map.get(hash(key));

      for(MapNode n : hashedItems)
        if(n.key == key){
          hashedItems.remove(n);
          items--;
          return;
        }
  }
  public int size(){return items;}

  public static void main(String[] args) {
    MyGoodHashMap hashMap = new MyGoodHashMap();
    hashMap.put(17, 17);
    hashMap.put(7, 7);
    hashMap.put(1, 1);
    hashMap.remove(7);
    hashMap.put(4, 4);
  }
}