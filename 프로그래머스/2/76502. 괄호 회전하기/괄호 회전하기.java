import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            String rotation = rotate(s, i);
            if (isValid(rotation)) answer++;
        }
        
        return answer;
    }
    
    private String rotate(String s, int idx) {
        String sub1 = s.substring(0, idx);
        String sub2 = s.substring(idx);
        StringBuilder sb = new StringBuilder();
        
        sb.append(sub2);
        sb.append(sub1);
        
        return sb.toString();
    }
    
    private boolean isValid(String rotation) {
        Deque<Character> stack = new ArrayDeque<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (char c : rotation.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pop() != map.get(c))) return false;
            }
        }
        
        if (!stack.isEmpty()) return false;
        
        return true;
    }
}