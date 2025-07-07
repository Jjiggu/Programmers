class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int n = times.length;
        long left = 1;
        long right = 100_001;
        
        while (left <= right) {
            long duration = 0;
            long level = (left + right) / 2;
            
            for (int i = 0; i < n; i++) {
                long diff = diffs[i];
                long time_cur = times[i];

                if (diff <= level) {
                    duration += time_cur;
                } else {
                    long time_prev = 0;
                    if (i > 0) {
                        time_prev = times[i - 1];   
                    }
                    duration += (diff - level) * (time_cur + time_prev) + time_cur;
                }
            }
            if (duration > limit) {
                left = level + 1;   
            } else {
                right = level - 1;
            }
        }
        
        
        return (int)left;
    }
}