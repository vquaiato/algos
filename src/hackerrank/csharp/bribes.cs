using System;
using System.Linq;

public class Bribes 
{
    public static void minimumBribes(int[] q){
        int bribes = 0;
        int len = q.Count();

        int i=0;
        while(i<len){
            int e = q[i];
            int ix = i+1;
            if((e - ix) > 3){
                Console.WriteLine("Too chaotic");
                return;
            }
            else
                if(e > ix){
                    int temp = q[i+1];
                    if(temp == ix || temp < e){
                        q[i+1] = e;
                        q[i] = temp;
                        i -= i > 0 ? 1 : 0;
                        bribes++;
                    }
                    else
                        i++;
                }
                else
                    i++;
        }

        Console.WriteLine(bribes);
    }
}