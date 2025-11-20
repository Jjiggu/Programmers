import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> type = new HashMap<>();
        for (int t : topping) type.put(t, type.getOrDefault(t, 0) + 1);
        
        int rightDistinct = type.size();
        int leftDistinct = 0;
        
        // 자르는 인덱스 기준 양쪽 토핑 개수만 알면 됨 (set으로 관리?)
        for (int i = 0; i < topping.length; i++) {
            int cur = topping[i];
            
            if (set.add(cur)) leftDistinct++;
            
            type.put(cur, type.get(cur) - 1);
            if (type.get(cur) == 0) rightDistinct--;
            
            if (leftDistinct == rightDistinct) answer++;
        }
        
        return answer;
    }
}