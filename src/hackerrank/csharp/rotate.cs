// using System;
// using System.Linq;

// public class Rotate{
//     public static int[] rotLeft(int[] a, int d) {
//         int len = a.Count();

//         if(d == len)
//             return a;

//         int shift = len - d;
//         Console.WriteLine($"shift: {shift}");

//         int rotations = 0;
        
//         while(rotations < d){
//             int finalPos = rotations+shift+shift;
//             Console.WriteLine($"finalPos: {finalPos}");
//             if(finalPos >= len){
//                 finalPos = len - finalPos;
//                 Console.WriteLine($"finalPos calculated: {finalPos}");
//             }

//             var temp = a[finalPos];
//             a[finalPos] = a[rotations+shift];
//             a[i] = temp;

//             rotations++;
//         }

//         // for(int i=d-1;i<len;i++)
//         // {
//         //     int finalPos = i+shift;
//         //     Console.WriteLine($"finalPos: {finalPos}");
//         //     if(finalPos >= len){
//         //         finalPos = len - finalPos;
//         //         Console.WriteLine($"finalPos calculated: {finalPos}");
//         //     }

//         //     var temp = a[finalPos];
//         //     a[finalPos] = a[i];
//         //     a[i] = temp;
//         // }

//         // foreach(var item in a)
//         //     Console.Write(item);

//         return a;
//     }
// }