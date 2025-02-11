import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] lans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        long low = 1;
        long high = Arrays.stream(lans).max().getAsInt();
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += lans[i] / mid;
            }

            if (count >= N) { // 충분한 개수를 만들 수 있음 -> 길이를 늘려봄
                ans = mid;
                low = mid + 1;
            } else { // 부족하면 길이를 줄여야 함
                high = mid - 1;
            }
        }

        System.out.print(ans);
    }
}
