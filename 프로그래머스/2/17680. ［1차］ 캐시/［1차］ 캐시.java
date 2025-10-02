import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return cities.length * 5;
        
        int time = 0;
        Deque<String> cache = new ArrayDeque<>();
            
        for (String city : cities) {
            city = city.toLowerCase(); 
            
            if (cache.remove(city)) { 
                time += 1; 
            } else {
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.pollFirst();
                }
            }
            cache.offerLast(city); 
        }
        
        return time;
    }
}