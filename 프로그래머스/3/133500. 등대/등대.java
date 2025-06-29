import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : lighthouse) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int dp[][] = new int[n + 1][2];
        dfs(1, 0, graph, dp);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int node, int parent, List<Integer>[] graph, int[][] dp) {
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for (int child : graph[node]) {
            if (child == parent) continue;
            
            dfs(child, node, graph, dp);
            
            dp[node][0] += dp[child][1];
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}