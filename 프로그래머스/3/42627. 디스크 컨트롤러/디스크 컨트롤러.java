import java.util.*;

class Job {
    int reqTime;
    int workTime;
    
    public Job(int reqTime, int workTime) {
        this.reqTime = reqTime;
        this.workTime = workTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int[] answer = new int[jobs.length];
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2) -> o1.workTime - o2.workTime);
        
        
        int time = 0;
        int totalTime = 0;
        int cnt = 0;
        int idx = 0;
        
        while (cnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            Job now = pq.poll();
            time += now.workTime;
            totalTime += (time - now.reqTime);
            cnt++;
        }

        
        return totalTime / jobs.length;
    }
}