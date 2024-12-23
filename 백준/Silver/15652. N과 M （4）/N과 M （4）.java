import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] arr;
    static int MAX = 10;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[MAX];

        back(0, 1);
    }


    public static void back(int k, int nowNum) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = nowNum; i <= N; i++) {
            if (nowNum <= i) {
                arr[k] = i;
                nowNum = i;
                back(k + 1, nowNum);
            }
        }
    }
}
