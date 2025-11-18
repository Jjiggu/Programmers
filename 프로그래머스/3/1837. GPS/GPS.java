import java.util.*;

class Solution {
    
    final int INF = 1_000_000_000;
    List<Integer>[] graph;
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        initGraph(n, edge_list);  // 그래프 초기화
        
        int[][] dp = new int[k][n + 1];  // dp 선언 dp[시간][정점] = 최소 수정 횟수
        
        for (int i = 0; i <k; i++) Arrays.fill(dp[i], INF);  // 최대값으로 초기화
        
        dp[0][gps_log[0]] = 0;  // 첫번째 노드는 수정 0회
        
        for (int t = 0; t < k - 1; t++) {  
            for (int u = 1; u <= n; u++) {
                if (dp[t][u] == INF) continue;  
                
                // int stay = dp[t][u] + (u == gps_log[t + 1] ? 0 : 1);
                // dp[t + 1][u] = Math.min(dp[t + 1][u], stay);  // 머무르기
                
                for (int v : graph[u]) {  // 인접된 노드로 이동
                    int move = dp[t][u] + (v == gps_log[t + 1] ? 0 : 1);
                    dp[t + 1][v] = Math.min(dp[t + 1][v], move);
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