using System;

public class Program {
    public static void Main(string[] args){
        var a = new int[]{2 ,3 ,4 ,1 ,5};

        Console.WriteLine(Swaps.minimumSwaps(a));
    }
}