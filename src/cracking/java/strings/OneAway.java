public class OneAway {
    public boolean isOneAway(String word1, String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();

        if(Math.abs(word1Length - word2Length) >1)
            return false;

        String smaller = word1;
        String bigger = word1;

        if(word1Length > word2Length)
            smaller = word2;
        if(word2Length > word1Length)
             bigger = word2;

        int diffs = 0;
        for(int i=0; i<smaller.length();i++)
        {
            if(smaller.charAt(i) != bigger.charAt(i))
            {
                if(word1Length == word2Length)
                    diffs++;

                if(word1Length!= word2Length && smaller.charAt(i)!=bigger.charAt(i+1))
                    diffs++;
            }
        }

        return diffs <2;
    }
}
