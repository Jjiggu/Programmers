import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alphaList;
    static char[] arr;
    static List<Character> vowelList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphaList = new char[C];
        arr = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphaList[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphaList);

        back(0, 0,0, 0);

        System.out.print(sb.toString());
    }

    public static void back(int k, int lastIdx, int vowelsCnt, int consonantsCnt) {
        if (k == L) {
            if (vowelsCnt >= 1 && consonantsCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = lastIdx; i < C; i++) {
            arr[k] = alphaList[i];

            if (vowelList.contains(alphaList[i])) {
                back(k + 1, i + 1,vowelsCnt + 1, consonantsCnt);
            } else {
                back(k + 1, i + 1, vowelsCnt, consonantsCnt + 1);
            }
        }
    }
}
