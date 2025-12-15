import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        int answer = 1;
        
        for (String[] cloth : clothes) map.computeIfAbsent(cloth[1], k -> new ArrayList<>()).add(cloth[0]);
        
        for (String key : map.keySet()) answer *= (map.get(key).size() + 1);
        
        return answer - 1;
    }
}