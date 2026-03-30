import java.util.*;

class Solution {
    
    class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    
    public int[] solution(String[][] places) {
        
        int n = places.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            String[] place = places[i];
            List<Pos> posList = findPos(place);  // P 좌표 찾기
            
            if (isValid(posList, place)) answer[i] = 1;         
        }
        
        return answer;
    }
    
    private boolean isValid(List<Pos> posList, String[] place) {
        int n = posList.size();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Pos a = posList.get(i);
                Pos b = posList.get(j);
                
                if (calcDist(a, b) > 2) continue;  // 맨해튼 거리 2이하인지 확인 
                if (!checkPartition(a, b, place)) return false;  // 거리 2이하인 경우 파티션 있는지 확인 
            }
        }
        
        return true;
    }
    
    private boolean checkPartition(Pos a, Pos b, String[] place) {
        int r1 = a.x;
        int r2 = b.x;
        int c1 = a.y;
        int c2 = b.y;
        int dist = calcDist(a, b);
        
        if (dist == 1) return false;
        if (dist == 2) {
            if (r1 == r2) {  // 같은 행에 있는 경우 
                int mc = (c1 + c2) / 2;
                return place[r1].charAt(mc) == 'X';
            } else if (c1 == c2) {  // 같은 열에 있는 경우
                int mr = (r1 + r2) / 2;
                return place[mr].charAt(c1) == 'X';
            } else {  // 대각선에 있는 경우 
                return place[r1].charAt(c2) == 'X' && place[r2].charAt(c1) == 'X';
            }   
        }
        
        return true;
    }
    
    // 좌표로 맨해튼 거리 2이하인지 확인 
    // 2이하라면 파티션 확인 
    private int calcDist(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    
    private List<Pos> findPos(String[] place) {
        int n = place.length;
        int m = place[0].length();
        List<Pos> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (place[i].charAt(j) == 'P') list.add(new Pos(i, j));
            }
        }
        
        return list;
    }
}
