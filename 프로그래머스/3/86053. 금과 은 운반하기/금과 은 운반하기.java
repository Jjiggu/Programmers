class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long right = (long) Math.max(a, b) * 100_000_000;
        long left = 0;
        
        while (left < right) {
            long mid = (left + right) / 2;
            
            if (isValid(mid, a, b, g, s, w, t)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean isValid(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length;
        long total = 0;
        long totalG = 0;
        long totalS = 0;
        
        for (int i = 0; i < n; i++) {
            long cnt = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i]) cnt++;
            
            long tmp = Math.min(cnt * w[i], g[i] + s[i]);
            total += tmp;
            totalG += Math.min(tmp, g[i]);
            totalS += Math.min(tmp, s[i]);
        }
        
        if (total >= a + b && totalG >= a && totalS>= b) return true;
        
        return false;
    }
}
