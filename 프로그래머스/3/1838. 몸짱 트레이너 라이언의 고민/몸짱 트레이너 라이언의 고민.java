import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        
        int[] diff = new int[722];
        for (int i = 0; i < m; i++) {
            diff[timetable[i][0] - 600]++;
            diff[timetable[i][1] - 600 + 1]--;
        }
        
        int sum = 0;
        int maxClient = 0;
        
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            maxClient = Math.max(maxClient, sum);
        }
        if (maxClient <= 1) return 0;
        
        int maxDist = 2 * (n - 1);
        for (int d = maxDist; d >= 1; d--) {
            if (canSeatAll(n, maxClient, d)) {
                return d;
            }
        }
        
        return 0;
    }
    
    private boolean canSeatAll(int n, int k, int d) {
        for (int s = 0; s < n; s++) {
            List<int[]> placed = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j < s) continue;
                    boolean canSeat = true;
                    
                    for (int[] p : placed) {
                        if (Math.abs(p[0] - i) + Math.abs(p[1] - j) < d) {
                            canSeat = false;
                            break;
                        }
                    }
                    
                    if (canSeat) {
                        placed.add(new int[]{i, j});
                        if (placed.size() == k) return true;
                    }
                }
            }
        }
        return false;
    }
}