class Solution {
    public int solution(int[] stones, int k) {
        int right = 200_000_000;
        int left = 0;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
        
    }
    
    
    public boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                skip++;
                if (skip >= k) {
                    return false;   
                }
            } else {
                skip = 0;
            }
        }
        
        return true;
     }
}