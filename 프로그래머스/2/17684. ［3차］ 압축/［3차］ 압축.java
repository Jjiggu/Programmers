import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> idxMap = ceateAlphaMap();
        List<Integer> answer = new ArrayList<>();
        int newIdx = 27;
        int n = msg.length();
        
        int i = 0;
        while (i < n) {
            String w = msg.substring(i, i + 1);
            int wLen = 1;
            
            for (int j = i + 1; j < n; j++) {
                String next = msg.substring(i, j + 1);

                if (idxMap.containsKey(next)) {
                    w = next;
                    wLen = next.length();

                    continue;
                } else {
                    idxMap.put(next, newIdx++);
                    break;
                }
            }   
            answer.add(idxMap.get(w));
            i += w.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    // 알파벳 목록 초기화 
    private Map<String, Integer> ceateAlphaMap() {  
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), idx++);
        }
        
        return dict;
    }
}