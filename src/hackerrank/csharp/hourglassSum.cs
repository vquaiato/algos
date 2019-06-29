using System;

public class HourglassSum
{
    public static int hourglassSum(int[][] arr)
    {
        arr = new int[][] {
            new int[] {-1,-1,0,-9,-2,-2},
            new int[] {-2,-1,-6,-8,-2,-5},
            new int[] {-1,-1,-1,-2,-3,-4},
            new int[] {-1,-9,-2,-4,-4,-5},
            new int[] {-7,-3,-1,-2,-4,-5},
            new int[] {-1,-3,-1,-2,-4,-5}
        };

        int max = 0;
        bool hasToInitMax = true;
        for (int y = 0; y < 4; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                var temp =
                arr[y][x] + arr[y][x + 1] + arr[y][x + 2] +
                arr[y + 1][x + 1] +
                arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2];

                if (temp > max || hasToInitMax){
                    max = temp;
                    hasToInitMax = false;
                }
            }
        }
        Console.WriteLine($"Max: {max}");

        return max;
    }
}