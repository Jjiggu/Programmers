import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for (String order : orders) {
            String[] menu = order.split("");
            Arrays.sort(menu);
            
            for (int c : course) {
                if (menu.length >= c) {
                    comb(0, menu, c, new StringBuilder());
                }
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (int len : course) {
            int maxCnt = 0;
            
            for (String key : map.keySet()) {
                int cnt = map.get(key);
                if (key.length() == len && cnt >= 2) {
                    maxCnt = Math.max(cnt, maxCnt);
                }
            }
            
            for (String key : map.keySet()) {
                int cnt = map.get(key);
                if (key.length() == len && cnt == maxCnt) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    private void comb(int start, String[] menu, int couseLen, StringBuilder sb) {
        if (sb.length() == couseLen) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        
        for (int i = start; i < menu.length; i++) {
            sb.append(menu[i]);
            comb(i + 1, menu, couseLen, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}