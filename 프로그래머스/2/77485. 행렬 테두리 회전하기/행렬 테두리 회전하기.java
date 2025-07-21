import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows + 1][columns + 1];
        int v = 1;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                board[r][c] = v++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0], y1 = queries[i][1];
            int x2 = queries[i][2], y2 = queries[i][3];

            int tmp = board[x1][y1];
            int min = tmp;

            // 왼쪽 세로줄 위→아래
            for (int r = x1; r < x2; r++) {
                board[r][y1] = board[r + 1][y1];
                min = Math.min(min, board[r][y1]);
            }
            // 아래 가로줄 왼→오
            for (int c = y1; c < y2; c++) {
                board[x2][c] = board[x2][c + 1];
                min = Math.min(min, board[x2][c]);
            }
            // 오른쪽 세로줄 아래→위
            for (int r = x2; r > x1; r--) {
                board[r][y2] = board[r - 1][y2];
                min = Math.min(min, board[r][y2]);
            }
            // 위쪽 가로줄 오→왼
            for (int c = y2; c > y1+1; c--) {
                board[x1][c] = board[x1][c - 1];
                min = Math.min(min, board[x1][c]);
            }
            board[x1][y1 + 1] = tmp;

            answer[i] = min;
        }
        return answer;
    }
}
