import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wants = new HashMap<>();
        Map<String, Integer> glocery = new HashMap<>();
        
        int answer = 0;
        int n = discount.length;
        
        for (int i = 0; i < want.length; i++) wants.put(want[i], number[i]);
        for (int i = 0; i < 10; i ++) {
            glocery.put(discount[i], glocery.getOrDefault(discount[i], 0) + 1);
        }
        
        if (isValid(want, wants, glocery)) answer++;
        
        for (int start = 1; start <= n - 10; start++) {
            glocery.put(discount[start - 1], glocery.getOrDefault(discount[start - 1], 0) - 1);
            glocery.put(discount[start + 9], glocery.getOrDefault(discount[start + 9], 0) + 1);
            
            if (isValid(want, wants, glocery)) answer++;
        }
        
        
        return answer;
    }
    
    private boolean isValid(String[] want, Map<String, Integer> wants, Map<String, Integer> glocery) {
        for (int i = 0; i < want.length; i++) {
            String item = want[i];
            int need = wants.get(item);
            int have = glocery.getOrDefault(item, 0);
            
            if (have < need) return false;
        }
        
        return true;
    }
}