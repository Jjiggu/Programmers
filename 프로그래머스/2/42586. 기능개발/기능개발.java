import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> q = calcProgressDays(progresses, speeds);

        int maxDay = q.poll();
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (maxDay < cur) {
                maxDay = cur;
                answer.add(cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private Deque<Integer> calcProgressDays(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Deque<Integer> need = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            int left = (100 - progresses[i]) % speeds[i];
            
            if (left == 0) need.offer(days);
            else need.offer(days + 1);
        }
        
        return need;
    }
}
