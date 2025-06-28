import java.util.*;

public class Solution {
    int N, M;
    int[] parent, size;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        
        parent[yr] = xr;
        size[xr] += size[yr];
    }

    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        parent = new int[N * M];
        size = new int[N * M];

        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1) {
                    int idx = i * M + j;
                    for (int d = 0; d < 2; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni < N && nj < M && land[ni][nj] == 1) {
                            int nidx = ni * M + nj;
                            union(idx, nidx);
                        }
                    }
                }
            }
        }


        Map<Integer, Integer> oil = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1) {
                    int idx = i * M + j;
                    int root = find(idx);
                    oil.put(root, oil.getOrDefault(root, 0) + 1);
                }
            }
        }

    
        int answer = 0;
        for (int col = 0; col < M; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < N; row++) {
                if (land[row][col] == 1) {
                    int idx = row * M + col;
                    int root = find(idx);
                    seen.add(root);
                }
            }
            int sum = 0;
            for (int root : seen) {
                sum += oil.get(root);
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
