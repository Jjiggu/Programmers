import java.util.*;

class Solution {
    public int solution(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : a) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        sortedKeys.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int maxLen = 0;
        
        for (int key : sortedKeys) {
            if (map.get(key) * 2 <= maxLen) break;
            
            int cnt = 0;
            for (int i = 0; i < a.length - 1;) {
                if (a[i] != a[i + 1] && (a[i] == key || a[i + 1] == key)) {
                    cnt++;
                    i += 2;
                } else {
                    i++;
                }
            }
            maxLen = Math.max(maxLen, cnt * 2);
        }
        
        return maxLen;
    }
}
