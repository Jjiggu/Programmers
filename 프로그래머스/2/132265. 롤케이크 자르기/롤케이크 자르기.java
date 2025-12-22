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
            
            littleBro.add(num);
            if (toppings.get(num) == 1) bigBro.remove(num);
            toppings.put(num, toppings.get(num) - 1);
            
            if (bigBro.size() == littleBro.size()) answer++;
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