class Solution { 
    public int solution(int[] diffs, int[] times, long limit) { 
        return bs(diffs, times, limit); 
    } 
    private int bs(int[] diffs, int[] times, long limit) { 
        int left = 1; 
        int right = Integer.MAX_VALUE; 
        while (left < right) { 
            int mid = left + (right - left) / 2;
            if (solveSimul(mid, diffs, times, limit)) { 
                right = mid; 
            } else { 
                left = mid + 1; 
            } 
        } 
        
        return left; 
    } 
    
    private boolean solveSimul(int proficiency, int[] diffs, int[] times, long limit) { 
        long time = 0L; 
        
        for (int i = 0; i < diffs.length; i++) { 
            int reqDiff = diffs[i]; 
            int reqTime = times[i]; 
            if (proficiency >= reqDiff) {  // 퍼즐 풀 수 있는 경우
                time += reqTime; 
            } else {  // 퍼즐 풀 수 없는 경우
                int digit = reqDiff - proficiency;
                int prevTime = i > 0 ? times[i - 1] : 0;
                int curTime = times[i];
                time += (long)(curTime + prevTime) * digit + curTime; 
            } if (time > limit) return false; 
        } 
        
        return true; 
    } 
}