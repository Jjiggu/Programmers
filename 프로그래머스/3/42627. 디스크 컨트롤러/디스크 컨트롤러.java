import java.util.*;

class Solution {
    
    class Job {
        int requestTime;
        int duration;
        
        public Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2) -> o1.duration - o2.duration);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int total = 0;
        int time = 0;
        int idx = 0;
        int count = jobs.length;
        
        while (idx < count || !pq.isEmpty()) {
            while (idx < count && jobs[idx][0] <= time) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (!pq.isEmpty()) {
                Job cur = pq.poll();
                time += cur.duration;
                total += (time - cur.requestTime);
            } else {
                time = jobs[idx][0];
            }
        }
        
        
        return total / count;
    }
}