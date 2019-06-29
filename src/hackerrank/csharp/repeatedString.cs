using System;

public class RepeatedString
{
    static long repeatedString(string s, long n)
    {
        long len = s.Length;
        int countInS = 0;
        foreach (var c in s)
            if (c == 'a')
                countInS++;

        Console.WriteLine($"countInS: {countInS}");

        long stringLenDiff = n - len;
        Console.WriteLine($"stringLenDiff: {stringLenDiff}");

        long stringDiff = stringLenDiff / len;
        Console.WriteLine($"stringDiff: {stringDiff}");

        long rem = stringLenDiff % len;
        Console.WriteLine($"rem: {rem}");

        long total = (stringDiff * countInS) + countInS;
        Console.WriteLine($"total: {total}");

        if (rem > 0)
        {
            int counted = 0;
            while (counted < rem)
            {
                if (s[counted] == 'a')
                    total++;

                counted++;
            }
        }

        return total;
    }
}