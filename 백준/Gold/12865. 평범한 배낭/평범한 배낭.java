import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물품 개수
        K = Integer.parseInt(st.nextToken()); // 최대 무게
        dp = new int[K + 1]; // DP 테이블 (무게별 최대 가치 저장)

        int[] weight = new int[N];
        int[] value = new int[N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // **Knapsack DP 구현**
        for (int i = 0; i < N; i++) {
            for (int w = K; w >= weight[i]; w--) { // 뒤에서부터 갱신
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }

        System.out.println(dp[K]); // 최대 가치 출력
    }
}
