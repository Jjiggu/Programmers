import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;
        
        for (String[] place : places) {
            List<int[]> pos = findPos(place);
            if (isValid(pos, place)) answer[idx++] = 1;
            else answer[idx++] = 0;
        }
        
        return answer;
    }
    
    private boolean isValid(List<int[]> pos, String[] place) {
        
        for (int i = 0; i < pos.size(); i++) {
            for (int j = i + 1; j < pos.size(); j++) {
                int[] a = pos.get(i);
                int[] b = pos.get(j);
                
                if (calcDist(a, b) > 2) continue;
                if (!checkPartition(a, b, place)) return false;
            }
        }
        return true;
    }
    
    private boolean checkPartition(int[] a, int[] b, String[] place) {
        int r1 = a[0], r2 = b[0];
        int c1 = a[1], c2 = b[1];
        int d = calcDist(a, b);
        
        if (d == 0) return true;
        if (d == 1) return false;
        
        if (d == 2) {
            if (r1 == r2) { // 같은 행
                int mc = (c1 + c2) / 2;
                return place[r1].charAt(mc) == 'X';
            } else if (c1 == c2) { // 같은 열
                int mr = (r1 + r2) / 2;
                return place[mr].charAt(c1) == 'X';
            } else { // 대각선
                return place[r1].charAt(c2) == 'X' && place[r2].charAt(c1) == 'X';
            }
        }
        
        
        return true;
    }
    
    private int calcDist(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
    
    private List<int[]> findPos(String[] place) {
        List<int[]> pos = new ArrayList<>();
        
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) == 'P') pos.add(new int[]{i, j});
            }
        }
        return pos;
    }
}
