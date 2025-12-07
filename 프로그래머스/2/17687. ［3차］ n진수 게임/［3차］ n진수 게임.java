class Solution {
    
    private static final char[] DIGITS = 
    {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    
    public String solution(int n, int t, int m, int p) {
        int num = t * m;
        StringBuilder sb = new StringBuilder();

        
        for (int i = 0; i <= num; i++) {
            String s = convert(i, n);
            sb.append(s);
        }
        
        int cnt = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i <= num; i += m) {
            if (cnt == t) break;
            
            answer.append(sb.charAt(i));
            cnt++;
        }
        
        return answer.toString();
    }
    
    private String convert(int num, int n) {
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(DIGITS[num % n]);
            num /= n;
        }
        
        return sb.reverse().toString();
    }
}