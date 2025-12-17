import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> q = new ArrayDeque<>();
        cities = cnvertUpperCase(cities);
        int answer = 0;
        
        for (String city : cities) {
            if (q.size() < cacheSize) {
                if (q.contains(city)) {  // 캐싱되어 있는 경우
                    answer += 1;
                    q.remove(city);
                    q.offer(city);
                } else {
                    answer += 5;
                    q.offer(city);
                }
            } else {
                if (q.contains(city)) {  // 캐싱되어 있는 경우
                    answer += 1;
                    q.remove(city);
                    q.offer(city);
                } else {
                    answer += 5;
                    q.offer(city);
                    q.poll();
                }
            }
        }
        
        return answer;
    }
    
    private String[] cnvertUpperCase(String[] cities) {
        String[] arr = new String[cities.length];
        int idx = 0;
        
        for (String city : cities) arr[idx++] = city.toUpperCase();
        
        return arr;
    }
}