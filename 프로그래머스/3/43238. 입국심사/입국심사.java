class Solution {
     
    static long MAX_VALUE = 100_000_000;

    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
    
    private long binarySearch(int n, int[] times) {   
        long left = 1;
        long right = MAX_VALUE * MAX_VALUE;
    
        while (left <= right) {
            
            long mid = (left + right) / 2;
            
            if (isValid(mid, times) >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private long isValid(long mid, int[] times) {
        long cnt = 0;
        
        for (int time : times) {
            cnt += mid / time;
        }
        
        return cnt;
    }
}