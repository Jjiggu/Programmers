import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
    
        for (int work : works) pq.offer(work);
        
        for (int i = 0; i < n; i++) {
            int num = pq.poll();
            pq.offer(num > 0 ? num - 1 : num);
        }
        
        while (!pq.isEmpty()) {
            result += (long)Math.pow(pq.poll(), 2);
        }
        
        return result;
    }
}