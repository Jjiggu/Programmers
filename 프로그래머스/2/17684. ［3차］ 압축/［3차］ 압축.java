import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = setAlphaMap();
        List<Integer> answer = new ArrayList<>();
        
        // 문자 하나씩 늘리면서 dict에 있는지 확인 
        // 있으면 길이 + 1
        // 없으면 현재 단어 dict에 추가하고 바로 전 단어 인덱스 기록 
        // 반복 
        int left = 0;
        int right = left + 1;
        int lastIdx = 26;
        int n = msg.length();
        String prev = "";;
        
        while (left < n) {
            String sub = msg.substring(left, right);
            
            if (right <= n && dict.containsKey(sub)) {
                prev = sub;
                
                if (right == n) {
                    answer.add(dict.get(prev));
                    break;
                }
                right++;
            } else {
                answer.add(dict.get(prev));
                
                String newSub = msg.substring(left, right);
                dict.put(newSub, ++lastIdx);
                
                left += prev.length();
                right = left + 1;
                prev = "";
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private Map<String, Integer> setAlphaMap() {
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), idx++);
        }
        
        return dict;
    }
}