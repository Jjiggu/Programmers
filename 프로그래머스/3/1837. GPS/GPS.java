import java.util.*;

class Solution {
    
    final int INF = 1_000_000_000;
    List<Integer>[] graph;
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        initGraph(n, edge_list);
        
        int[][] dp = new int[k][n + 1];
        for (int i = 0; i <k; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][gps_log[0]] = 0;
        
        for (int i = 0; i < k - 1; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == INF) continue;
                
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                
                for (int v : graph[j]) {
                    dp[i + 1][v] = Math.min(dp[i + 1][v], dp[i][j]);
                }
            }
            
            for (int v = 1; v <= n; v++) {
                if (v != gps_log[i + 1]) {
                    dp[i + 1][v]++;
                }
            }
        }
        
        int answer = dp[k - 1][gps_log[k - 1]];
        
        return answer >= INF ? -1 : answer;
    }
    
    private void initGraph(int n, int[][] edge_list) {
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edge_list) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
    }
}