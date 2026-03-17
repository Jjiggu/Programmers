import java.util.*;

class Solution {
    
    class Job {
         String name;
        int start;
        int playTime;
        int leftTime;
        
        public Job(String name, int start, int playTime, int leftTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
            this.leftTime = leftTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        Job[] jobArr = new Job[n];
        
        for (int i = 0; i < n; i++) {
            String[] plan = plans[i];
            String name = plan[0];
            int start = startToInt(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            Job job = new Job(name, start, playTime, 0);
            jobArr[i] = job;
        }
        
        Arrays.sort(jobArr, (o1, o2) -> o1.start - o2.start);
        
        
        
        List<String> answer = new ArrayList<>();
        Deque<Job> stack = new ArrayDeque<>();
        
        Job now = jobArr[0];
        int curTime = now.start;
        
        for (int i = 1; i < n; i++) {
            Job next = jobArr[i];
            int gap = next.start - curTime;
            
            if (gap >= now.playTime) {
                curTime += now.playTime;
                answer.add(now.name);
                gap = next.start - curTime;
                
                while (!stack.isEmpty() && gap > 0) {
                    Job paused = stack.pop();
                    if (gap >= paused.leftTime) {
                        curTime += paused.leftTime;
                        gap -= paused.leftTime;
                        answer.add(paused.name);
                    } else {
                        paused.leftTime -= gap;
                        curTime += gap;
                        gap = 0;
                        stack.push(paused);
                    }
                }
                
                now = next;
                curTime = next.start;
            } else {
                now.leftTime = now.playTime - gap;
                stack.push(now);
                now = next;
                curTime = next.start;
            }
        }
        
        answer.add(now.name);
        while(!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private int startToInt(String time) {
        String[] arr = time.split(":");
        
        return 60 * Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
    }
}