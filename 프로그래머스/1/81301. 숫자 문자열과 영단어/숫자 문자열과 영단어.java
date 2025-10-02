import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, Integer> numberMap = init();
        
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {  
                answer.append(c);
                sb.setLength(0); 
            } else {
                sb.append(c);
                if (numberMap.containsKey(sb.toString())) {
                    answer.append(numberMap.get(sb.toString()));
                    sb.setLength(0);
                }    
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
    
    private Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        return map;
    }
}