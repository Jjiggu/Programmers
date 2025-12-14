import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 이 위치에서 h 후보
            if (citations[i] >= h) return h; // 첫 만족하는 h가 최대 h-index
        }
        
        return 0;
    }
}