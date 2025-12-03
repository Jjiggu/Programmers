class Solution {
    
    private static final int LIMIT = 10_000_000;
    
    public int[] solution(long begin, long end) {
        int n = (int)(end - begin + 1);
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            long num = begin + i;
            
            if (num == 1) answer[i] = 0;
            else answer[i] = findPrime(num);
        }
        
        return answer;
    }
    
    private int findPrime(long n) {
        long sqrt = (long)Math.sqrt(n);
        int res = 1;
        
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                long pair = n / i;
                
                if (pair <= LIMIT) return (int)pair;
                if (i <= LIMIT) res = (int)i;
            }
        }
        
        return res;
    }
}
