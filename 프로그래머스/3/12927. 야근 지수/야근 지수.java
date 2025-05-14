import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) pq.offer(work);
        
        doOvertime(n);
        
        return pqSum(pq);
    }
    
    
    public void doOvertime(int n) {
        
        while (n > 0) {
            int num = pq.poll();
            
            pq.offer(num > 0 ? num - 1 : num);
            n--;
        }
    }
    
    
    private long pqSum(PriorityQueue<Integer> pq) {
        long result = 0;
        
        while(!pq.isEmpty()) {
            result += Math.pow(pq.poll(), 2);
        }
        
        return result;
    }
}