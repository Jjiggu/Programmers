import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int[] num = convertToInt(numbers);
        
        dfs(0, num, new boolean[numbers.length()], new StringBuilder());
        
        return set.size();
    }
    
    private void dfs(int k, int[] num, boolean[] isUse, StringBuilder sb) {
        if (k == num.length) {
            if (isPrime(sb.toString())) set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        if (sb.length() > 0 && isPrime(sb.toString())) set.add(Integer.parseInt(sb.toString()));
        
        for (int i = 0; i < num.length; i++) {
            if (isUse[i]) continue;
                
            sb.append(num[i]);
            isUse[i] = true;
            dfs(k + 1, num, isUse, sb);
            isUse[i] = false;
            sb.delete(sb.length() - 1, sb.length());
        }
    }
    
    private boolean isPrime(String number) {
        int n = Integer.parseInt(number);
        
        if (n < 2) return false; 

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    private int[] convertToInt(String numbers) {
        int[] number = new int[numbers.length()];
        int idx = 0;
        
        for (String c : numbers.split("")) {
            number[idx++] = Integer.parseInt(c);
        }
        
        return number;
    }
}