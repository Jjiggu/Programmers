class Solution {
    public int solution(String name) {
        int upDown = cntUpDownMoves(name);
        int leftRight = leftRightMoves(name);
        
        return upDown + leftRight;
    }
    
    public int cntUpDownMoves(String name) {
        int upDown = 0;
        
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            int move = Math.min(ch - 'A', 'Z' - ch + 1);
            upDown += move;
        }
        return upDown;
    } 
    
    public int leftRightMoves(String name) {
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            
            while(next < name.length() && name.charAt(next) == 'A') next++;
            
            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        return move;
    }
}