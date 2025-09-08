import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] pulse1 = new long[n];
        long[] pulse2 = new long[n];
        
        pulse1[0] = sequence[0];
        pulse2[0] = -sequence[0];
        
        long answer = Math.max(pulse1[0], pulse2[0]);
        
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                pulse1[i] = Math.max(sequence[i], pulse1[i - 1] + sequence[i]); 
                pulse2[i] = Math.max(-sequence[i], pulse2[i - 1] - sequence[i]); 
            } else {
                pulse1[i] = Math.max(-sequence[i], pulse1[i - 1] - sequence[i]); 
                pulse2[i] = Math.max(sequence[i], pulse2[i - 1] + sequence[i]); 
            }
            answer = Math.max(answer, Math.max(pulse1[i], pulse2[i]));
        }
        
        return answer;
    }
}
