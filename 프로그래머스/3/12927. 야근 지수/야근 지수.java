import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) pq.add(work);
        
        doOvertime(n);
        
        return pqSum(pq);
    }
    
    
    public void doOvertime(int n) {
        
        for (int i = 0; i < n; i++) {
            int nowNum = pq.poll();
            nowNum--;
            
            if (nowNum > 0) pq.offer(nowNum);
            else pq.offer(0);
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