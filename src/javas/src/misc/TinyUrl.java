// https://leetcode.com/problems/encode-and-decode-tinyurl/

package misc;

import java.util.HashMap;

public class TinyUrl {
    HashMap<Long, String> map;

    public TinyUrl(){
        map = new HashMap<>();
    }
    
    private long getHash(String url){
        return Math.abs(url.hashCode());
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {   
        Long hash = getHash(longUrl);
        map.put(hash, longUrl);
        
        return "http://tinyurl.com/" + hash.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortUrl.endsWith("/"))
            shortUrl = shortUrl.substring(shortUrl.length() - 1, 1);
            
        int lastSlash = shortUrl.lastIndexOf("/");
        String hash = shortUrl.substring(lastSlash + 1, shortUrl.length());
        String longUrl = map.get(Long.parseLong(hash));
        
        return longUrl;
    }
}