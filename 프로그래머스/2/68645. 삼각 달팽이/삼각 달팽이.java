import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] a = new int[n][n];
        int x = -1, y = 0;
        int num = 1;
        int dir = 0;
        
        for (int len = n; len >= 1; len--) {
            for (int k = 0; k < len; k++) {
                if (dir == 0) {
                    x++;
                } else if (dir == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                a[x][y] = num++;
            }
            dir = (dir + 1) % 3;
        }
        
        int total = n * (n + 1) / 2;
        int idx = 0;
        int[] answer = new int[total];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = a[i][j];
            }
        }
        
        return answer;
    }
}
