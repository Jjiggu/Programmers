import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        long fact = factorial(n);

        for (int i = 0; i < n; i++) {
            fact /= (n - i); 
            int index = (int)((k - 1) / fact);
            answer[i] = numbers.remove(index);
            k = (k - 1) % fact + 1;
        }

        return answer;
    }

    private long factorial(int n) {
        long num = 1;
        for (int i = 1; i <= n; i++) num *= i;
        return num;
    }
}