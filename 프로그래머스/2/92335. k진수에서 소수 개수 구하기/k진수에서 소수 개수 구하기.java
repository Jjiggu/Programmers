import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String s = Long.toString(n, k);  // k진수 변환
        String[] parts = s.split("0+");  // 0 기준 분리
        int answer = 0;
        
        for (String part : parts) {
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
