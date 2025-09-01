import java.util.*;

class Solution {        
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, computers, visited);
                result++;
            }
        }
        
        return result;
    }
    
    private void bfs(int idx, int[][] computers, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(idx);
        
        while(!q.isEmpty()) {
            int nowIdx = q.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (i != nowIdx && computers[nowIdx][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}