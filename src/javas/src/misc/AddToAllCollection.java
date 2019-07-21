package misc;

import java.util.HashMap;

public class AddToAllCollection {
  int addedToAll = 0, currentIndex = 0;
  HashMap<Integer, Integer> numbers;
  public AddToAllCollection() {
    numbers = new HashMap<>();
  }

  public void append(int val){
    this.numbers.put(currentIndex++, val - addedToAll);
  }
  public int getAt(int index){
    return numbers.get(index) + addedToAll;
  }
  public void addToAll(int val){
    this.addedToAll += val;
  }

  public static void main(String[] args) {
    AddToAllCollection ata = new AddToAllCollection();
    ata.append(1);
    print("Added 1");
    ata.append(2);
    print("Added 2");
    ata.append(3);
    print("Added 3");

    print("Get 0" + ata.getAt(0));
    print("Get 1" + ata.getAt(1));
    print("Get 2" + ata.getAt(2));

    ata.addToAll(5);
    print("Added to all 5");

    ata.append(5);
    print("Added 3");

    print("Get 0" + ata.getAt(0));
    print("Get 1" + ata.getAt(1));
    print("Get 2" + ata.getAt(2));
    print("Get 3" + ata.getAt(3));
  }
  static void print(Object o){
    System.out.print(o + " ");
  }
}