class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int left = 0;
        int right = 0;
        int minLeft = -1;
        int minRight = -1;
        int minLen = Integer.MAX_VALUE;
        int n = sequence.length;
        
        while (right < n) {
            if (sum < k) {
                if (right + 1 == n) break;
                sum += sequence[++right];
            } else {
                if (sum == k) {
                    int curLen = right - left;

                    if (curLen < minLen) {
                        minLen = curLen;
                        minLeft = left;
                        minRight = right;
                    }
                }
                sum -= sequence[left++];
            }
        }   
        
        
        return new int[]{minLeft, minRight};
    }
}