using System;
using System.Linq;

public class Clouds
{
    static int jumpingOnClouds(int[] clouds)
    {
        int jumps = 0;
        Console.WriteLine(clouds);

        for (int i = 0; i < clouds.Count(); i++)
        {
            jumps++;
            Console.WriteLine($"i: {i} jumps: {jumps}");

            if ((i + 2) <= clouds.Count() && clouds[i + 2] == 0)
                i += 1;
        }
        return jumps;
    }
}