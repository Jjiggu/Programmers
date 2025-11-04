class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long left = 0;
        long right = 400_000_000_000_000L;
        long mid = right;
        
        while (left <= right) {
            mid = (left + right) / 2;
            
            if (canCarry(mid, a, b, g, s, w, t)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canCarry(long T, int A, int B, int[] g, int[] s, int[] w, int[] t) {
        long sumGold = 0;
        long sumSilver = 0;
        long sumTotal = 0;
        
        for (int i = 0; i < g.length; i++) {
            long ti = t[i];
            long wi = w[i];
            
            long trips = T / (2L * ti);  // T안에 가능한 운반 횟수
            if (T % (2L * ti) >= ti) trips++;
            
            long cap = trips * wi;
            long gold = Math.min(cap, (long)g[i]);
            long silver = Math.min(cap, (long)s[i]);
            long total = Math.min(cap, (long) g[i] + (long) s[i]);
            
            sumGold += gold;
            sumSilver += silver;
            sumTotal += total;
            
            if (sumGold >= A && sumSilver >= B && sumTotal >= (long) A + B) {
                return true;
            }
        }
        
        return sumGold >= A && sumSilver >= B && sumTotal >= (long) A + B;
    }
}
