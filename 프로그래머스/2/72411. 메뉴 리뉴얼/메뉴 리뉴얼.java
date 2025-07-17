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
        
        List<String> answerList = new ArrayList<>();
        for (int len : course) {
            int max = 0;
            List<String> tmp = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : combCnt.entrySet()) {
                String comb = entry.getKey();
                int cnt = entry.getValue();
                
                if (comb.length() == len && cnt >= 2) {
                    max = Math.max(max, cnt);
                }
            }
            for (Map.Entry<String, Integer> entry : combCnt.entrySet()) {
                String comb = entry.getKey();
                int cnt = entry.getValue();
                if (comb.length() == len && cnt == max && cnt >= 2) {
                    answerList.add(comb);
                }
            }
        }
        
        Collections.sort(answerList);
        
        return answerList.toArray(new String[0]);
    }
    
    public void comb(String order, int courseLenth, int start, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == courseLenth) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, courseLenth, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}