import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        
        
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            sum1 += queue1[i];
        }
        for (int i = 0; i < n; i++) {
            arr[n + i] = queue2[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        if (total % 2 == 1) return -1;
        long target = total / 2;
        
        int left = 0;
        int right = n;
        int ops = 0;
        int LIMIT = n * 3;
        
        while (ops <= LIMIT) {
            if (sum1 == target) return ops;
            
            if (sum1 > target) {
                int val = arr[left % (n * 2)];
                left++;
                sum1 -= val;
                sum2 += val;
            } else {
                int val = arr[right % (n * 2)];
                right++;
                sum2 -= val;
                sum1 += val;
            }
            ops++;
        }
    
        return -1;
    }
}