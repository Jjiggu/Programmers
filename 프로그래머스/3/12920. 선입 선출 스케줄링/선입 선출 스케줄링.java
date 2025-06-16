class Solution {
    public int solution(int n, int[] cores) {
        long jobCnt = n - cores.length;
        long startTime = findStartTime(jobCnt, cores);
        
        long processBefore = cores.length;
        for (int core : cores) {
            processBefore += (startTime - 1) / core;
        }
        
        long leftTask = n - processBefore;
        
        for (int i = 0; i < cores.length; i++) {
            if (startTime % cores[i] == 0) {
                leftTask--;
                if (leftTask == 0) return i + 1;
            }
        }
        
        return -1;
        
    }
    
    private long findStartTime(long taskCount, int[] cores) {
        long left = 0;
        long right = 500_000_000;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (canProcess(mid, taskCount, cores)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    
    private boolean canProcess(long time, long taskCount, int[] cores) {
        long done = 0;
        for (int core : cores) {
            done += time / core;
            if (done >= taskCount) return true; 
        }
        
        return false;
    }
}
