import java.util.*;

class Solution {
    static Queue<Integer> q;
    static boolean[] visited;
        
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        q = new LinkedList<>();
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.add(i);
                bfs(q, computers, n, visited);
                result++;   
            }
        }
        
        return result;
    }
    
    public void bfs(Queue<Integer> q, int[][] computers, int n, boolean[] visited) {
        
        while (!q.isEmpty()) {
            int num = q.poll();
            
            for (int i = 0; i < n; i++) {
                if (i != num && computers[num][i] == 1) {
                    if (visited[i] == false) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}