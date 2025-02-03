import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String word1, word2;
    static int maxX, maxY;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word1 = br.readLine();
        word2 = br.readLine();

        maxX = word1.length() + 1;
        maxY = word2.length() + 1;

        dp = new int[maxX][maxY];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(findMax(dp));
        findLCS(dp, word1.length(), word2.length(), sb);
        System.out.print(sb.reverse().toString());
    }

    public static int findMax(int[][] dp) {
//        int maxNum = -1;
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//                if (dp[i][j] > maxNum) maxNum = dp[i][j];
//            }
//        }
//
//        return maxNum;
        return dp[word1.length()][word2.length()];
    }

    public static void findLCS(int[][] dp, int startX, int startY, StringBuilder sb) {

        if (dp[startX][startY] == 0 || startX == 0 || startY == 0) {
            return;
        }

        if (dp[startX][startY] == dp[startX - 1][startY]) {
            findLCS(dp, startX - 1, startY, sb);
        } else if (dp[startX][startY] == dp[startX][startY - 1]) {
            findLCS(dp, startX, startY - 1, sb);
        } else {
            sb.append(word1.charAt(startX - 1));
            findLCS(dp, startX - 1, startY - 1, sb);
        }
    }
}
