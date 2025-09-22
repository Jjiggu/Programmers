import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        int[] answer = new int[n];
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i; // n! 계산

        k--; // 0-index로 맞춤
        for (int i = 0; i < n; i++) {
            fact /= (n - i); // (n-i-1)! 값
            int index = (int)(k / fact); 
            answer[i] = numbers.remove(index); // index번째 수 선택
            k %= fact;
        }

        return answer;
    }
}
