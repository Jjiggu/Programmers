import java.util.*;

class Solution {
    public int solution(int n) {
        
        String binaryN = Integer.toBinaryString(n);
        int nCnt = findOneCnt(binaryN);
        int nowNum = n + 1;
            
        while (true) {
            String binaryNum = Integer.toBinaryString(nowNum);
            
            if (nCnt == findOneCnt(binaryNum)) {
                int result = Integer.parseInt(binaryNum, 2);
                
                return result;
            }
            
            nowNum++;
        }
        
    }
    
    private int findOneCnt(String binaryNum) {
        int cnt = 0;
        
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '1') {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    
}