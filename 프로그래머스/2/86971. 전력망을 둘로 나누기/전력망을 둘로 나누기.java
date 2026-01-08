import java.util.*;

class Solution {
    List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        initGraph(n, wires);
        
        for (int[] wire : wires) {
            int blockU = wire[0];
            int blockV = wire[1];
            
            boolean[] visited = new boolean[n + 1];
            int comp = dfs(blockU, blockU, blockV, visited);
            
            int diff = Math.abs(n - 2 * comp);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfs(int cur, int blockU, int blockV, boolean[] visited) {
        visited[cur] = true;
        int cnt = 1;
        
        for (int next : graph[cur]) {
            if ((cur == blockU && next == blockV) || (cur == blockV && next == blockU)) continue;
            if (!visited[next]) cnt += dfs(next, blockU, blockV, visited);
        }
        
        return cnt;
    }
    
    private void initGraph(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        return;
    }
}