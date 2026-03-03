class Solution {
    public int solution(int n, long l, long r) {
        return (int)(countOnes(n, r) - countOnes(n, l - 1));
    }
    
    private long countOnes(int n, long x) {
        if (x <= 0) return 0;
        if (n == 0) return 1;
        
        long blockLen = pow5(n - 1);  // 각 블록 길이 = 5^(n-1)
        long onesPerBlock = pow4(n - 1);  // 한 블록 내 1 개수 = 4^(n-1)
        
        long fullBlocks = x / blockLen;  // 완전히 포함되는 블록 수 
        long remainder = x % blockLen;  // 마지막 부분 
        
        long res = 0;
        
        for (int i = 0; i < fullBlocks; i++) {
            if (i == 2) continue;
            res += onesPerBlock;
        }
        
        if (fullBlocks == 2 || fullBlocks >= 5) {
            return res;
        }
        
        res += countOnes(n - 1, remainder);
        return res;
    }
    
    private long pow5(int e) {
        long v = 1;
        for (int i = 0; i < e; i++) v *= 5L;
        return v;
    }
    
    private long pow4(int e) {
        long v = 1;
        for (int i = 0; i < e; i++) v *= 4L;
        return v;
    }
}