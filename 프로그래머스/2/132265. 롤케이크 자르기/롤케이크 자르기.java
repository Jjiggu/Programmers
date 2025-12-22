import java.util.*;

class Solution {
    
    Map<Integer, Integer> toppings;
    Set<Integer> bigBro = new HashSet<>();
    Set<Integer> littleBro = new HashSet<>();
    
    public int solution(int[] topping) {
        cntToppings(topping);
        int answer = 0;
        
        for (int i = 0; i < topping.length; i++) {
            int num = topping[i];  // 현재 토핑 
            
            littleBro.add(num);  // 동생 토핑 추가
            toppings.put(num, toppings.get(num) - 1);  // 철수 토핑 개수 -1
            if (toppings.get(num) == 0) bigBro.remove(num);  // 토핑 개수 0개인 경우 토핑 삭제 
            
            if (bigBro.size() == littleBro.size()) answer++;  // 토핑 개수 같은 경우
        }
        
        return answer;
    }
    
    private void cntToppings(int[] topping) {
        toppings = new HashMap<>();

        for (int t : topping) {
            toppings.put(t, toppings.getOrDefault(t, 0) + 1);
            bigBro.add(t);
        }
    }
}