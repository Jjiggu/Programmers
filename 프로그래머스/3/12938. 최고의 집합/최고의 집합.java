import java.util.*;

public class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] { -1 }; // 불가능한 경우

        int[] answer = new int[n];
        int quotient = s / n;
        int remainder = s % n;

        Arrays.fill(answer, quotient);

        for (int i = 0; i < remainder; i++) {
            answer[n - 1 - i] += 1;
        }

        return answer;
    }
}
