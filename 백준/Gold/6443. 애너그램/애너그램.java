import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[] word;
    static char[] arr;
    static boolean[] isUsed;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Set<String> uniquePermutations = new HashSet<>();

        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();

            String line = br.readLine();

            word = new char[line.length()];
            arr = new char[line.length()];
            isUsed = new boolean[line.length()];

            for (int j = 0; j < line.length(); j++) {
                word[j] = line.charAt(j);
            }

            Arrays.sort(word);

            back(0, uniquePermutations);

            uniquePermutations.stream().sorted().forEach(s -> sb.append(s).append("\n"));
            System.out.print(sb);

            uniquePermutations.clear();
        }
    }

    public static void back(int k, Set<String> uniquePermutations) {
        if (k == word.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length; i++) {
                sb.append(arr[i]);
            }
            uniquePermutations.add(sb.toString());
            return;
        }

        for (int j = 0; j < word.length; j++) {
            if (!isUsed[j]) {
                // 중복된 문자를 건너뛰도록 개선
                if (j > 0 && word[j] == word[j - 1] && !isUsed[j - 1]) {
                    continue;
                }
                
                arr[k] = word[j];
                isUsed[j] = true;
                back(k + 1, uniquePermutations);
                isUsed[j] = false;
            }
        }
    }
}
