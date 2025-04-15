import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, 0, -1};         // d, l, r, u
    static int[] dy = {0, -1, 1, 0};
    static String[] direction = {"d", "l", "r", "u"};
    
    static int N, M, targetX, targetY, maxDepth;
    static String answer = "impossible";
    static boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        targetX = r;
        targetY = c;
        maxDepth = k;

        // 가지치기: 불가능한 경우 미리 리턴
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";

        dfs(x, y, 0, new StringBuilder());
        return answer;
    }

    private void dfs(int x, int y, int depth, StringBuilder path) {
        if (found) return; // 사전순 정답 찾으면 바로 종료

        if (depth == maxDepth) {
            if (x == targetX && y == targetY) {
                answer = path.toString();
                found = true;
            }
            return;
        }

        // 가지치기: 남은 거리로 도착 못하는 경우 중단
        int dist = Math.abs(x - targetX) + Math.abs(y - targetY);
        if (dist > (maxDepth - depth)) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > N || ny > M) continue;

            path.append(direction[i]);
            dfs(nx, ny, depth + 1, path);
            path.deleteCharAt(path.length() - 1); // 백트래킹
        }
    }
}
