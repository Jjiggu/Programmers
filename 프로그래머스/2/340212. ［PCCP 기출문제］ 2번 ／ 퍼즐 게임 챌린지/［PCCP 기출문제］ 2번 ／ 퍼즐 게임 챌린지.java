class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return bs(diffs, times, limit);
    }
    
    private int bs(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 300_001;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (solve(diffs, times, mid, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean solve(int[] diffs, int[] times, int level, long limit) {
        long timeRequired = 0;
        int n = diffs.length;
        
        timeRequired += times[0];
        
        for (int i = 1; i < n; i++) {
            if (timeRequired > limit) return false;
            
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = times[i - 1];
            
            if (diff <= level) {
                timeRequired += timeCur;
            } else {
                int wrong = diff - level;
                int timeTaken = timeCur + timePrev;
                timeRequired += (wrong * timeTaken + timeCur);
            }
        } 
        
        return timeRequired <= limit;
    }
}