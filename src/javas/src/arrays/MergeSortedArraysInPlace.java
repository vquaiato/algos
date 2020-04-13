package arrays;

public class MergeSortedArraysInPlace {
  public void Merge(int[] arr1, int[] arr2) {
    int index1 = arr1.length-1;
    int index2 = arr2.length-1;

    while(index2 >= 0){
      if(arr2[index2] <= arr1[index1])
      {
        int x = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2--] = x;

        while(index1 > 0 && arr1[index1] <= arr1[index1-1]){
          x = arr1[index1-1];
          arr1[index1-1] = arr1[index1];
          arr1[index1--] = x;
        }
        index1 = arr1.length-1;
      }
      else
        index2--;
    }

    for (int i : arr1) {
      System.out.println(i);      
    }

    System.out.println("----");
    
    for (int i : arr2) {
      System.out.println(i);      
    }
  }

  public static void main(String[] args){
    new MergeSortedArraysInPlace().Merge(new int[] {1,1,1,1}, 
                                        new int[]{2,3,4,6,8});
  }
}