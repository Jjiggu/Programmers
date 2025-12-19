import java.util.*;

class Solution {
    
    class Process {
        int priority;
        int idx;
        
        Process(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }
    
    TreeSet<Integer> maxSet = new TreeSet<>(Collections.reverseOrder());
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[] priorities, int location) {
        Deque<Process> q = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            int num = priorities[i];
            q.offer(new Process(num, i));
            maxSet.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int curMax = maxSet.pollFirst();
        int cnt = 0;
        while (!q.isEmpty()) {
            Process cur = q.poll();
            int priority = cur.priority;
            int idx = cur.idx;
            
            if (priority == curMax) {
                if (idx == location) return cnt + 1;
                map.put(priority, map.get(priority) - 1);
                cnt++;
                if (map.get(priority) == 0) curMax = maxSet.pollFirst();
            } else {
                q.offer(cur);
            }
        }
        
        return priorities.length;
    }
}