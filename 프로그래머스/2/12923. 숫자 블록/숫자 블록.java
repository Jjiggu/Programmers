class Solution {
    
    private static final int LIMIT = 10_000_000;
    
    public int[] solution(long begin, long end) {
        // 짝수인 경우 /2 값이 제일 큰 수 
        // 소수인 경우 1
        // 홀수인 경우 자신을 제외한 가장 큰 약수
        
        int n = (int)(end - begin + 1);
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            long num = begin + i;
            
            if (num == 1) answer[i] = 0;
            else answer[i] = findNum(num);
        }
        
        return answer;
    }
    
    private int findNum(long num) {
        long maxRange = (long)Math.sqrt(num);
        int maxNum = 1;
        
        for (long i = 2; i <= maxRange; i++) {
            if (num % i == 0) {
                long pair = num / i;
                
                if (pair <= LIMIT) return (int) pair;
                else maxNum = (int)i;
                // if (i <= LIMIT) maxNum = (int)i;
            }
        }
        
        return maxNum;
    }
}
