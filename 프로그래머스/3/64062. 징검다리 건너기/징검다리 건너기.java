class Solution {
    
    static final int MAX_VALUE = 200_000_000;
    
    public int solution(int[] stones, int k) {
        return binarySearch(stones, k);
    }
    
    private int binarySearch(int[] stones, int k) {
        int left = 0;
        int right = MAX_VALUE;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (!canCross(mid, stones, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left - 1;
    }
    
    private boolean canCross(int mid, int[] stones, int k) {
        int cnt = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                cnt++;
                if (cnt >= k) return false;
            } else {
                cnt = 0;   
            }
        }
        
        return true;
    }
 }