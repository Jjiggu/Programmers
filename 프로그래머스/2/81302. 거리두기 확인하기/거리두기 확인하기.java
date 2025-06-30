class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            answer[i] = isValid(places[i]) ? 1 : 0;
        }
        
        return answer;
    }

    public boolean isValid(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!checkDistOne(place, i, j) || !checkDistTwo(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkDistOne(String[] place, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = { 0, 0,-1, 1};
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 &&
                place[nx].charAt(ny) == 'P') {
                return false;
            }
        }
        return true;
    }

    public boolean checkDistTwo(String[] place, int x, int y) {
        int[] dx = {-2, 2, 0, 0};
        int[] dy = { 0, 0,-2, 2};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            int mx = x + dx[i] / 2; 
            int my = y + dy[i] / 2;
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 &&
                place[nx].charAt(ny) == 'P' &&
                place[mx].charAt(my) != 'X') {
                return false;
            }
        }

        int[] dxd = {1, 1,-1,-1};
        int[] dyd = {1,-1, 1,-1};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dxd[i];
            int ny = y + dyd[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 &&
                place[nx].charAt(ny) == 'P') {
                if (place[x].charAt(ny) != 'X' ||
                    place[nx].charAt(y)  != 'X') {
                    return false;
                }
            }
        }
        return true;
    }
}
