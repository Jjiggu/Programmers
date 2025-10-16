import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        List<Integer>[] graph = buildGraph(n, lighthouse);
        
        int[][] dp = new int[n + 1][2];
        
        dfs(1, 0, graph, dp);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int node, int parent, List<Integer>[] graph, int[][] dp) {
        dp[node][0] = 0;  // 현재 노드를 끄는 경우 필요한 최소 등대 수 
        dp[node][1] = 1;  // 현재 노드를 켜는 경우 필요한 최소 등대 수 
        
        for (int child : graph[node]) {
            if (child == parent) continue;
            
            dfs(child, node, graph, dp);
            
            dp[node][0] += dp[child][1];  // 부모 노드가 꺼진 경우 자식은 무조건 켜져있어야 함
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);  // 부모 노드가 켜진 경우 자식 노드가 꺼져있거나 켜진 경우 중 작은 값이 들어와야 함 
        }
        
    }
    
    private List<Integer>[] buildGraph(int n, int[][] lighthouse) {
        List<Integer>[] g = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        
        for (int[] light : lighthouse) {
            int u = light[0];
            int v = light[1];
            g[u].add(v);
            g[v].add(u);
        }
        
        return g;
    }
}