class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        String s = "A".repeat(n);
        
        // 위 아래
        answer += moveUpDown(n, name);
        // 좌우 
        answer += moveLeftRight(n, name);
        
        return answer;
    }
    
    private int moveLeftRight(int n, String name) {
        int move = n - 1;
        
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;
            
            move = Math.min(move, i * 2 + (n - next)); 
            move = Math.min(move, i + 2 * (n - next));
        }
        
        return move;
    }
    
    // 위 아래로 움직이는 경우
    // 아스키 코드값 비교해서 작은쪽으로 이동하면 됨
    private int moveUpDown(int n, String name) {        
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            if (c == 'A') continue;
            int up = c - 'A';
            int down = 'Z' - c + 1;
            cnt += Math.min(up, down);
        }
        return cnt;
    }
}