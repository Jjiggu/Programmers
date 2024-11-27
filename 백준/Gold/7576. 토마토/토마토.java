import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main { // 파일 이름을 Main.java로 변경
    static int[][] maps;
    static int n;
    static int m;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        q = new LinkedList<>();
        dist = new int[n][m];

        // 지도 입력 처리 (공백으로 구분된 숫자)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 초기 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0; // 초기 ripe tomato의 거리 0
                }
                if (maps[i][j] == 0) {
                    dist[i][j] = -1; // unripe tomato의 거리 초기화
                }
                // maps[i][j] == -1인 경우, dist[i][j]는 0으로 유지 (벽)
            }
        }

        // BFS 탐색
        while (!q.isEmpty()) {
            int node[] = q.poll();
            int currentX = node[0];
            int currentY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == -1) continue; // 벽
                if (dist[nx][ny] >= 0) continue; // 이미 방문

                dist[nx][ny] = dist[currentX][currentY] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        result = 0;

        // 최종 결과 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == -1) {
                    continue; // 벽은 무시
                }
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dist[i][j]);
            }
        }

        System.out.println(result);
    }
}
