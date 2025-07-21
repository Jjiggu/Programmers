import java.util.*;

class Solution {
        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        // 1. 그래프 생성
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edge_list) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        // 2. DP 초기화
        final int INF = 1_000_000_000;
        int[][] dp = new int[k][n+1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][gps_log[0]] = 0;

        // 3. DP 전이
        for (int t = 0; t < k-1; t++) {
            // 이동·머무르기 전이
            for (int u = 1; u <= n; u++) {
                if (dp[t][u] == INF) continue;
                // 머무르기
                dp[t+1][u] = Math.min(dp[t+1][u], dp[t][u]);
                // 인접 이동
                for (int v : adj.get(u)) {
                    dp[t+1][v] = Math.min(dp[t+1][v], dp[t][u]);
                }
            }
            // 로그 수정 비용 반영
            for (int v = 1; v <= n; v++) {
                if (v != gps_log[t+1]) {
                    dp[t+1][v]++;
                }
            }
        }

        // 4. 결과 반환
        int ans = dp[k-1][ gps_log[k-1] ];
        return ans >= INF ? -1 : ans;
    }
}