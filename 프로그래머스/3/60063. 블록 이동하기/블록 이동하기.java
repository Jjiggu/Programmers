import java.util.*;

class Solution {

    static class Block {
        int x1, y1, x2, y2, time;

        Block(int x1, int y1, int x2, int y2, int time) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.time = time;
        }

        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Block)) return false;
            Block b = (Block) o;
            return ((x1 == b.x1 && y1 == b.y1 && x2 == b.x2 && y2 == b.y2) ||
                    (x1 == b.x2 && y1 == b.y2 && x2 == b.x1 && y2 == b.y1));
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1 + x2, y1 + y2); 
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        Queue<Block> queue = new LinkedList<>();
        Set<Block> visited = new HashSet<>();

        Block start = new Block(0, 0, 0, 1, 0);
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Block cur = queue.poll();

            
            if ((cur.x1 == n - 1 && cur.y1 == n - 1) || (cur.x2 == n - 1 && cur.y2 == n - 1)) {
                return cur.time;
            }

            
            for (int[] next : move(cur, board)) {
                Block nextBlock = new Block(next[0], next[1], next[2], next[3], cur.time + 1);
                if (!visited.contains(nextBlock)) {
                    visited.add(nextBlock);
                    queue.offer(nextBlock);
                }
            }

            
            for (int[] next : rotate(cur, board)) {
                Block nextBlock = new Block(next[0], next[1], next[2], next[3], cur.time + 1);
                if (!visited.contains(nextBlock)) {
                    visited.add(nextBlock);
                    queue.offer(nextBlock);
                }
            }
        }

        return -1; 
    }

    
    private List<int[]> move(Block b, int[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = board.length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int nx1 = b.x1 + dx[i];
            int ny1 = b.y1 + dy[i];
            int nx2 = b.x2 + dx[i];
            int ny2 = b.y2 + dy[i];

            if (isFree(nx1, ny1, board) && isFree(nx2, ny2, board)) {
                result.add(new int[]{nx1, ny1, nx2, ny2});
            }
        }

        return result;
    }

    
    private List<int[]> rotate(Block b, int[][] board) {
        List<int[]> result = new ArrayList<>();
        int n = board.length;

        if (b.x1 == b.x2) {
            for (int d = -1; d <= 1; d += 2) {
                if (isFree(b.x1 + d, b.y1, board) && isFree(b.x2 + d, b.y2, board)) {
                    result.add(new int[]{b.x1, b.y1, b.x1 + d, b.y1});
                    result.add(new int[]{b.x2, b.y2, b.x2 + d, b.y2});
                }
            }
        }
        
        else if (b.y1 == b.y2) {
            for (int d = -1; d <= 1; d += 2) {
                if (isFree(b.x1, b.y1 + d, board) && isFree(b.x2, b.y2 + d, board)) {
                    result.add(new int[]{b.x1, b.y1, b.x1, b.y1 + d});
                    result.add(new int[]{b.x2, b.y2, b.x2, b.y2 + d});
                }
            }
        }

        return result;
    }

    private boolean isFree(int x, int y, int[][] board) {
        int n = board.length;
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == 0);
    }
}
