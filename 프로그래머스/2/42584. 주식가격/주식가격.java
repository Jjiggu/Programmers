import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            
            for (int j = i + 1; j < n; j++) {        
                if (prices[j] < prices[i]) {
                    answer[i] = j - i;
                    break;
                } else {
                    answer[i] = n - (i + 1);
                }
            }
        }
        
        return answer;
    }
}