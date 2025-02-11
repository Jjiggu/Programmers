import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());  // 배열 크기 입력
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 이진 탐색을 위해 정렬

        M = Integer.parseInt(br.readLine());  // 찾을 숫자의 개수 입력
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {  // ✅ `M`으로 수정
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }

        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;

            if (key <= arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static int upperBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;

            if (key < arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
