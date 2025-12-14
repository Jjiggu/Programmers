class Solution {
    public int[] solution(int n, long left, long right) {
        int len  = (int)(right - left + 1);
        int[] answer = new int[len];
        
        for (long k = left, t = 0; k <= right; k++, t++) {
            long i = k / n;
            long j = k % n;
            answer[(int)t] = (int)(Math.max(i, j) + 1);
        }
        
        return answer;
    }
}