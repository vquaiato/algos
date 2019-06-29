public class BinarySearch {
  public int search(int[] arr, int key) {
    return search(arr, key, 0, arr.length - 1);
  }

  private int search(int[] arr, int key, int l, int h) {
    System.out.println("l: " + l + " h: " + h);
    if (l > h)
      return -1;

    int pivot = (l + h) / 2;

    if (arr[pivot] == key)
      return pivot;
    else {
      if (key < arr[pivot]) h = pivot -1;
      else l = pivot +1;
      
      return search(arr, key, l, h);
    }
  }
}