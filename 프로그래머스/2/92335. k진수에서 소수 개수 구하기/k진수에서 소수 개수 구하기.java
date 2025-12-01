import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1) k진수 변환
        String s = Long.toString(n, k);

        // 2) 0을 기준으로 조각 분리
        String[] parts = s.split("0+");

        int answer = 0;

        // 3) 각 조각이 소수인지 판별
        for (String part : parts) {
            if (part.isEmpty()) continue; // 빈 문자열 무시

            long num = Long.parseLong(part);

            if (isPrime(num)) answer++;
        }

        return answer;
    }

    // 4) 소수 판별 (long 범위)
    private boolean isPrime(long num) {
        if (num < 2) return false; // 0, 1 모두 소수 아님

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
