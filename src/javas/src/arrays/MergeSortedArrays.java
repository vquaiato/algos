package arrays;

public class MergeSortedArrays {
  public int[] Merge(int[] arr1, int[] arr2){
    int index1 = 0, index2 = 0, indexm = 0;
    int totalSize = arr1.length + arr2.length;
    int[] merged = new int[totalSize];

    while(indexm < totalSize) {
      if(index1 < arr1.length) {
        if(index2 > arr2.length - 1 || arr1[index1] <= arr2[index2])
        {
          merged[indexm++] = arr1[index1++];
        }
        else
        {
          merged[indexm++] = arr2[index2++];
        }
      }
      else
      {
        merged[indexm++] = arr2[index2++];
      }
    }
    
    return merged;
  }

  public static void main(String[] args){
    int[] a = new int[] {};
    int[] b = new int[] {1, 2, 3, 5};

    int[] merged = new MergeSortedArrays().Merge(a,b);
    for (int i : merged) {
        System.out.println(i);
    }
  }
}