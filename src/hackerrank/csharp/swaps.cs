using System;
using System.Linq;

public class Swaps
{
    public static int minimumSwaps(int[] arr)
    {
        var visited = new bool[arr.Length];
        int swaps = 0;

        for (int i = 0; i < arr.Length; i++)
        {
            int j = i, cycles = 0;
            while (!visited[j])
            {
                visited[j] = true;
                j = arr[j] - 1;
                cycles++;
            }
            if (cycles != 0)
                swaps += cycles - 1;
        }

        return swaps;
    }
}