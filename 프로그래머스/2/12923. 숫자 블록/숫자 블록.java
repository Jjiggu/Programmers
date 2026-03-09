class Solution {
    
    private static int LIMIT = 10_000_000;
    
    public int[] solution(long begin, long end) {
        int n = (int)(end - begin + 1);
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = gcd(begin++);
        }
        
        return answer;
    }
    
    private int gcd(long num) {
        if (num == 1) return 0;
        
        int maxNum = 1;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                long pair = num / i;
                
                if (pair <= LIMIT) return (int)pair;
                else maxNum = (int)i;
            }
        }  
        
        return maxNum;
    }
}