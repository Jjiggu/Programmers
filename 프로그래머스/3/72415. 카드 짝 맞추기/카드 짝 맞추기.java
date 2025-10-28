import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    List<List<Integer>> flipCardOrder = new ArrayList<>();
    List<Integer> cardList;
    Map<Integer, List<int[]>> cardPos;
    int minDist = Integer.MAX_VALUE;
    
    public int solution(int[][] board, int r, int c) {
        findCardType(board);
        permutation(new ArrayList<>(), new boolean[cardList.size()]);
        findCardPos(board);
        
        for (List<Integer> flipOrder : flipCardOrder) {
            int[][] copyBoard = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                copyBoard[i] = board[i].clone();  // 각 행을 따로 복사
            }
            int[] cur = new int[]{r, c};
            int totalDist = 0;
            
            for (int num : flipOrder) {
                int[] p1 = cardPos.get(num).get(0);
                int[] p2 = cardPos.get(num).get(1);
                
                int path1 = bfs(cur, p1, copyBoard) + bfs(p1, p2, copyBoard) + 2; // Enter 2번 포함
                int path2 = bfs(cur, p2, copyBoard) + bfs(p2, p1, copyBoard) + 2;
                
                if (path1 <= path2) {
                    totalDist += path1;
                    cur = p2; // 마지막으로 뒤집은 카드 위치
                } else {
                    totalDist += path2;
                    cur = p1;
                }
                
                copyBoard[p1[0]][p1[1]] = 0;
                copyBoard[p2[0]][p2[1]] = 0;
            }  
            
            minDist = Math.min(minDist, totalDist);
        }
        
        return minDist;
    }
    
    private int bfs(int[] start, int[] goal, int[][] board) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[4][4];
        int dist = 0;
        
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            
           if (x == goal[0] && y == goal[1]) return d;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (inRange(nx, ny, board) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int[] jump = ctrlMove(x, y, dir, board);
                int nx = jump[0];
                int ny = jump[1];
                
                if (inRange(nx, ny, board) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    private int[] ctrlMove(int x, int y, int dir, int[][] board) {
        
        int nx = x, ny = y;
        
        while (true) {
            int tx = nx + dx[dir]; 
            int ty = ny + dy[dir];
            
            if (!inRange(tx, ty, board)) break; 
            
            nx = tx;
            ny = ty;
            
            if (board[nx][ny] != 0) break;
        }
        
        return new int[]{nx, ny};
    }
    
    private boolean inRange(int x, int y, int[][] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
    
    private void permutation(List<Integer> arr, boolean[] used) {
        if (arr.size() == cardList.size()) {
            flipCardOrder.add(new ArrayList<>(arr));
            return;
        }
        
        for (int i = 0; i < cardList.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                arr.add(cardList.get(i));
                permutation(arr, used);
                arr.remove(arr.size() - 1);   
                used[i] = false;
            }
        }
    }
    
    private void findCardType(int[][] board) {
        Set<Integer> cardSet = new HashSet<>();
        
        for (int[] b : board) {
            for (int num : b) {
                if (num == 0) continue;
                cardSet.add(num);
            }
        }
        
        cardList = new ArrayList<Integer>(cardSet);
        
        return;
    }
    
    private void findCardPos(int[][] board) {
        cardPos = new HashMap<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j];
                if (num == 0) continue; // 빈칸은 패스

                // 맵에 카드 번호가 없으면 새 리스트 생성
                cardPos.putIfAbsent(num, new ArrayList<>());

                // 좌표 저장
                cardPos.get(num).add(new int[]{i, j});
            }
        }
    }
}
