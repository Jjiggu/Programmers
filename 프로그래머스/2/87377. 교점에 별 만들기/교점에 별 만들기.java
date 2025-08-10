import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> pts = new ArrayList<>();
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        int n = line.length;
        for (int i = 0; i < n; i++) {
            long a1 = line[i][0], b1 = line[i][1], c1 = line[i][2];
            for (int j = i + 1; j < n; j++) {
                long a2 = line[j][0], b2 = line[j][1], c2 = line[j][2];

                long det = a1 * b2 - a2 * b1;           // 분모
                if (det == 0) continue;                 // 평행 또는 일치

                long xNum = b1 * c2 - b2 * c1;          // x 분자
                long yNum = a2 * c1 - a1 * c2;          // y 분자

                // 정수 좌표인지 확인 (det로 나누어떨어지는지)
                if (xNum % det != 0 || yNum % det != 0) continue;

                long x = xNum / det;
                long y = yNum / det;

                pts.add(new long[]{x, y});
                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }
        }

        // 교점이 없을 수는 없지만(문제 조건상), 안전 처리
        if (pts.isEmpty()) return new String[]{};

        int H = (int)(maxY - minY + 1); // 행(위가 큰 y)
        int W = (int)(maxX - minX + 1); // 열(왼쪽이 작은 x)

        char[][] board = new char[H][W];
        for (int r = 0; r < H; r++) Arrays.fill(board[r], '.');

        for (long[] p : pts) {
            int col = (int)(p[0] - minX);   // x 기준
            int row = (int)(maxY - p[1]);   // y 큰 값이 0행(위)
            board[row][col] = '*';
        }

        String[] ans = new String[H];
        for (int r = 0; r < H; r++) ans[r] = new String(board[r]);
        return ans;
    }
}
