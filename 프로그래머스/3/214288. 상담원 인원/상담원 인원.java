import java.util.*;

class Solution {
    
    int minWait = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        List<int[]>[] byType = new ArrayList[k];
        for (int i = 0; i < k; i++) byType[i] = new ArrayList<>();
        for (int[] req : reqs) byType[req[2] - 1].add(new int[]{req[0], req[1]});
        for (int i = 0; i < k; i++) byType[i].sort((o1, o2) -> o1[0] - o2[0]);
        
        int[] mentors = new int[k];
        Arrays.fill(mentors, 1);
        
        dfs(k, 0, n - k, mentors, byType);
        
        return minWait;
    }
    
    private void dfs(int k, int idx, int left, int[] mentors, List<int[]>[] byType) {
        if (idx == k) {
            if (left == 0) {
                int wait = totalWait(byType, mentors);
                minWait = Math.min(minWait, wait);
            }
            return;
        }
        
        for (int i = 0; i <= left; i++) {
            mentors[idx] += i;
            dfs(k, idx + 1, left - i, mentors, byType);
            mentors[idx] -= i;
        }
    }
    
    private int totalWait(List<int[]>[] byType, int[] mentors) {
        int total = 0;
        
        for (int t = 0; t < byType.length; t++) {
            List<int[]> list = byType[t];
            if (list.isEmpty()) continue;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < mentors[t]; i++) pq.offer(0);
            
            int waitSum = 0;
            for (int[] req : list) {
                int start = req[0];
                int dur = req[1];
                int finish = pq.poll();
                
                if (finish <= start) {
                    pq.offer(start + dur);
                } else {
                    waitSum += (finish - start);
                    pq.offer(finish + dur);
                }
            }
            total += waitSum;
        }
        return total;
    }
}