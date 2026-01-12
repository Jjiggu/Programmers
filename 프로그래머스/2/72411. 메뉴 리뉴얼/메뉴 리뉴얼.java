import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> combCnt = new HashMap<>();
        
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);
            
            for (int len : course) {
                if (sortedOrder.length() < len) continue;
                comb(sortedOrder, len, 0, new StringBuilder(), combCnt);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (int len : course) {
            int maxCnt = 0;
            
            for (String key : combCnt.keySet()) {
                int cnt = combCnt.get(key);
                if (key.length() == len && cnt >= 2) {
                    maxCnt = Math.max(cnt, maxCnt);
                }
            }
            
            for (String key : combCnt.keySet()) {
                int cnt = combCnt.get(key);
                if (key.length() == len && cnt == maxCnt) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void comb(String order, int courseLen, int start, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == courseLen) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, courseLen, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}