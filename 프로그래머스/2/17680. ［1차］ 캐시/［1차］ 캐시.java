import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        List<String> cache = new ArrayList<>();
        int answer = 0;
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            city = city.toLowerCase();
                
            if (cache.size() == 0) {
                cache.add(city);
                answer += 5;
            }
            
            if (cache.size() < cacheSize) {
                if (cache.contains(city)) {
                    cache.remove(city);
                    cache.add(city);
                    answer += 1;
                } else {
                    cache.add(city);
                    answer += 5;
                }
            } else {
                if (cache.contains(city)) {
                    cache.remove(city);
                    cache.add(city);
                    answer += 1;
                } else {
                    cache.remove(0);
                    cache.add(city);
                    answer += 5;
                }
            }
        }
        
        return answer - 1;
    }
}