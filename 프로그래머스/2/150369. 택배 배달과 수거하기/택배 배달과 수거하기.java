class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIdx = n - 1;
        int pIdx = n - 1;
        
        while(dIdx >= 0 || pIdx >= 0) {
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;
            if (dIdx < 0 && pIdx < 0) break;
            
            int dist = Math.max(dIdx, pIdx) + 1;
            answer += dist * 2L;
                
            int capD = cap;
            int capP = cap;
            
            for (int i = dIdx; i >= 0 && capD > 0; i--) {
                if (deliveries[i] == 0) continue;
                int take = Math.min(capD, deliveries[i]);
                deliveries[i] -= take;
                capD -= take;
            }
            
            for (int i = pIdx; i >= 0 && capP > 0; i--) {
                if (pickups[i] == 0) continue;
                int take = Math.min(capP, pickups[i]);
                pickups[i] -= take;
                capP -= take;
            }
            
        }
        
        return answer;
    }
}