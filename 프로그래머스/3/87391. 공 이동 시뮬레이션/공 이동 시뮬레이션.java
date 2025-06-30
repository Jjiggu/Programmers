class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {

        long rowLo = x, rowHi = x;
        long colLo = y, colHi = y;

        for (int i = queries.length - 1; i >= 0; --i) {
            int cmd = queries[i][0];
            int dx  = queries[i][1];

            switch (cmd) {
                case 0:  // 왼쪽으로 dx만큼 이동: col = max(0, p - dx)
                    if (colLo == 0) {
                        // 이전 col 값이 0 이었던 구간이 경계에 닿았다면, [0, colHi+dx]
                        colHi = Math.min(m - 1, colHi + dx);
                    } else {
                        // 경계에 닿지 않았다면 p>=dx 이어야 하므로 [colLo+dx, colHi+dx]
                        colLo += dx;
                        colHi += dx;
                        if (colLo > m - 1) return 0;
                        colHi = Math.min(colHi, m - 1);
                    }
                    break;

                case 1:  // 오른쪽으로 dx만큼 이동: col = min(m-1, p + dx)
                    if (colHi == m - 1) {
                        // 이전 col 값이 m-1 이었던 구간이 경계에 닿았다면, [colLo-dx, m-1]
                        colLo = Math.max(0, colLo - dx);
                    } else {
                        // 경계 밖으로 안 나갔다면 p+dx<=m-1 이므로 [colLo-dx, colHi-dx]
                        colLo -= dx;
                        colHi -= dx;
                        if (colHi < 0) return 0;
                        colLo = Math.max(colLo, 0);
                    }
                    break;

                case 2:  // 위로 dx만큼 이동: row = max(0, p - dx)
                    if (rowLo == 0) {
                        rowHi = Math.min(n - 1, rowHi + dx);
                    } else {
                        rowLo += dx;
                        rowHi += dx;
                        if (rowLo > n - 1) return 0;
                        rowHi = Math.min(rowHi, n - 1);
                    }
                    break;

                case 3:  // 아래로 dx만큼 이동: row = min(n-1, p + dx)
                    if (rowHi == n - 1) {
                        rowLo = Math.max(0, rowLo - dx);
                    } else {
                        rowLo -= dx;
                        rowHi -= dx;
                        if (rowHi < 0) return 0;
                        rowLo = Math.max(rowLo, 0);
                    }
                    break;
            }

            if (rowLo > rowHi || colLo > colHi) return 0;
        }

        return (rowHi - rowLo + 1) * (colHi - colLo + 1);
    }
}
