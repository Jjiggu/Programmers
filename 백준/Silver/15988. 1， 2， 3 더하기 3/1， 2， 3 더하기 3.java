import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            int num = Integer.parseInt(br.readLine());

            dp = new long[Math.max(num + 1, 4)];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= num; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            }

            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}
