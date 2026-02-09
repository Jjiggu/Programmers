import java.util.*;

class Solution {    
    
    Set<List<Integer>> coordinateSet = new HashSet<>();
    
    public String[] solution(int[][] line) {
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                calcCoordinate(line[i], line[j]);
            }
        }
        
        return buildAnswer();
    }
    
    private String[] buildAnswer() {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        for (List<Integer> p : coordinateSet) {
            int x = p.get(0);
            int y = p.get(1);
            
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }
        
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        
        char[][] board = new char[height][width];
        for (int i = 0; i < height; i++) Arrays.fill(board[i], '.');
        
        for (List<Integer> p : coordinateSet) {
            int x = p.get(0), y = p.get(1);
            int col = x - minX;
            int row = maxY - y;  
            board[row][col] = '*';
        }
        
        String[] answer = new String[height];
        int idx = 0;
        for (char[] b : board) {
            answer[idx] = String.valueOf(b);
            idx++;
        }
        
        return answer;
    }
    
    private void calcCoordinate(int[] function1, int[] function2) {
        List<Integer> intersection = new ArrayList<>();
        
        long a = function1[0], b = function1[1], e = function1[2];
        long c = function2[0], d = function2[1], f = function2[2];
        
        long demon = a * d - b * c;
        if (demon == 0) return;  // 기울기가 0인 경우
        
        if ((b * f - e * d) % demon != 0 || (e * c - a * f) % demon != 0) return;  // 정수 좌표만 저장
        
        intersection.add((int)((b * f - e * d) / demon));
        intersection.add((int)((e * c - a * f) / demon));
        
        coordinateSet.add(intersection);
        
        return;
    }
}
