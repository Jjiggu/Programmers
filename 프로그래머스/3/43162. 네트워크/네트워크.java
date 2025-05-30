import java.util.*;

class Solution {        
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(computers, i, visited);
                result++;
            }
        }
        
        return result;
    }
    
    
    private void bfs(int[][] computers, int startNum, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNum);
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (i != num && computers[num][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        
    }
}