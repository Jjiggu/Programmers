public class Solution {
    public int solution(String s) {
        int minLen = s.length();
        int n = s.length();
        
        for (int i = 1; i < n; i++) {  // 길이 1부터 s.length까지 탐색
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int repeat = 1;
            
            for (int j = i; j < n; j += i) {
                
                String cur = s.substring(j, Math.min(j + i, n));
                
                if (prev.equals(cur)) { // 패턴이 동일한 경우에는 반복 +1
                    repeat++;
                } else {  // 다른 패턴이 발견되는 경우
                    if (repeat > 1) sb.append(repeat);
                    sb.append(prev);
                    prev = cur;
                    repeat = 1;
                }
            }
            
            if (repeat > 1) sb.append(repeat);
            sb.append(prev);
            
            minLen = Math.min(minLen, sb.length());
        }
        
        return minLen;
    }
}
