import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        // 1. 카드 위치 파악
        Map<Integer, List<int[]>> cardPos = new HashMap<>();
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                if (board[i][j] != 0) {
                    cardPos.computeIfAbsent(board[i][j], k->new ArrayList<>()).add(new int[]{i,j});
                }
        
        // 2. 카드 숫자 순열 완전탐색
        List<Integer> cards = new ArrayList<>(cardPos.keySet());
        List<List<Integer>> orders = permute(cards);
        for (List<Integer> order : orders) {
            dfs(board, order, 0, r, c, 0);
        }
        return answer;
    }
    
    // DFS로 카드 순서대로 모든 제거 경로 탐색
    void dfs(int[][] board, List<Integer> order, int idx, int x, int y, int cnt) {
        if (idx == order.size()) {
            answer = Math.min(answer, cnt);
            return;
        }
        int num = order.get(idx);
        List<int[]> pos = find(board, num);
        // 두 가지 순서(카드1→카드2, 카드2→카드1) 모두 고려
        for (int[] first : pos) {
            for (int[] second : pos) {
                if (Arrays.equals(first, second)) continue;
                // 1. first → second 순서로 뒤집기
                int move1 = move(board, x, y, first[0], first[1]);
                int move2 = move(board, first[0], first[1], second[0], second[1]);
                board[first[0]][first[1]] = 0;
                board[second[0]][second[1]] = 0;
                dfs(board, order, idx+1, second[0], second[1], cnt + move1 + move2 + 2);
                board[first[0]][first[1]] = num;
                board[second[0]][second[1]] = num;
            }
        }
    }
    
    // 한 카드 쌍의 위치 반환
    List<int[]> find(int[][] board, int num) {
        List<int[]> result = new ArrayList<>();
        for (int i=0; i<4; i++)
            for (int j=0; j<4; j++)
                if (board[i][j] == num)
                    result.add(new int[]{i, j});
        return result;
    }

    // BFS로 (sx,sy)→(ex,ey) 최소 이동 횟수 반환
    int move(int[][] board, int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[4][4];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0]==ex && cur[1]==ey) return cur[2];
            // 4방향 이동
            for (int d=0; d<4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (0<=nx && nx<4 && 0<=ny && ny<4 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2]+1});
                }
                // Ctrl 이동
                int[] ctrl = ctrlMove(board, cur[0], cur[1], dx[d], dy[d]);
                if (!visited[ctrl[0]][ctrl[1]]) {
                    visited[ctrl[0]][ctrl[1]] = true;
                    q.offer(new int[]{ctrl[0], ctrl[1], cur[2]+1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    // Ctrl+방향 이동
    int[] ctrlMove(int[][] board, int x, int y, int dx, int dy) {
        int nx = x, ny = y;
        while (true) {
            int tx = nx + dx, ty = ny + dy;
            if (!(0<=tx && tx<4 && 0<=ty && ty<4)) break;
            nx = tx; ny = ty;
            if (board[nx][ny] != 0) break;
        }
        return new int[]{nx, ny};
    }
    
    // 모든 순열 구하기
    List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, new boolean[nums.size()], new ArrayList<>(), res);
        return res;
    }
    void perm(List<Integer> nums, boolean[] v, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<nums.size(); i++) {
            if (v[i]) continue;
            v[i]=true; path.add(nums.get(i));
            perm(nums, v, path, res);
            v[i]=false; path.remove(path.size()-1);
        }
    }
}
