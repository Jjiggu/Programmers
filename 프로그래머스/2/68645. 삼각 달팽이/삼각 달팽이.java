import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] a = new int[n][n];
        int x = -1, y = 0;        // 시작 전에 한 칸 위에서 시작한다고 생각
        int num = 1;              // 채울 숫자
        int dir = 0;              // 0: down, 1: right, 2: up-left

        for (int len = n; len >= 1; len--) {
            for (int k = 0; k < len; k++) {
                if (dir == 0) {       // down
                    x++;
                } else if (dir == 1) {// right
                    y++;
                } else {              // up-left
                    x--;
                    y--;
                }
                a[x][y] = num++;
            }
            dir = (dir + 1) % 3;
        }

        int total = n * (n + 1) / 2;
        int[] res = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                res[idx++] = a[i][j];
            }
        }
        return res;
    }
}
