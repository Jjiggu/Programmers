class Solution {
    private final int MOD = 10007;

    public int solution(int n, int[] tops) {
        int[][] dp = new int[n + 1][2];
        dp[0][1] = 1;

        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int k = i + 1;

            // (1) 아래칸이 '빈 삼각형' 상태로 끝나는 경우
            dp[k][0] = (dp[i][0] + dp[i][1]) % MOD;

            // (2) 아래칸이 '아무것도 없는' 상태로 끝나는 경우
            if (top == 0) {
                dp[k][1] = (dp[i][0] + dp[i][1] * 2) % MOD;
            } else {
                dp[k][1] = (dp[i][0] * 2 + dp[i][1] * 3) % MOD;
            }
        }

        return (dp[n][0] + dp[n][1]) % MOD;
    }
}
