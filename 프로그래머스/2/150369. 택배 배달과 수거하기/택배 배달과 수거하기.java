class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIdx = n - 1;
        int pIdx = n - 1;
        
        while (dIdx >= 0 || pIdx >= 0) {
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;
            if (dIdx < 0 && pIdx < 0) break;
            
            long dist = Math.max(pIdx, dIdx) + 1;
            answer += dist * 2L;
            
            int capD = cap;
            int capP = cap;
            
            for (int i = dIdx; i >= 0; i--) {
                if (capD <= 0) break;
                if (deliveries[i] == 0 || capD <= 0) continue;
                int takeD = Math.min(capD, deliveries[i]);
                deliveries[i] -= takeD;
                capD -= takeD;
            }
            
            for (int i = pIdx; i >= 0; i--) {
                if (capP <= 0) break;
                if (pickups[i] == 0) continue;
                int takeP = Math.min(capP, pickups[i]);
                pickups[i] -= takeP;
                capP -= takeP;
            }
        }
        
        return answer;
    }
}