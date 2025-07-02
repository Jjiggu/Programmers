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
        
        Stack<Job> pause = new Stack<>();
        List<String> done = new ArrayList<>();
        
        Job now = jobArr[0];
        int currentTime = now.start;
        
        for (int i = 1; i < n; i++) {
            Job next = jobArr[i];
            int gap = next.start - currentTime;
            
            if (gap >= now.playTime) { 
                currentTime += now.playTime;
                done.add(now.name);
                gap = next.start - currentTime;
                
                while(!pause.isEmpty() && gap > 0) {
                    Job paused = pause.pop();
                    if (gap >= paused.leftTime) {
                        currentTime += paused.leftTime;
                        gap -= paused.leftTime;
                        done.add(paused.name);
                    } else {
                        paused.leftTime -= gap;
                        currentTime += gap;
                        gap = 0;
                        pause.push(paused);
                    }
                }
                
                now = next;
                currentTime = next.start;
            
            } else { 
                now.leftTime = now.playTime - gap;
                pause.push(now);
                now = next;
                currentTime = next.start;
            }    
        }
        
        done.add(now.name);
        while (!pause.isEmpty()) {
            done.add(pause.pop().name);
        }
        
        return done.toArray(new String[0]);
    }
    
    public int startToInt(String start) {
        String[] time = start.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        
        return hour * 60 + min;
    }
}