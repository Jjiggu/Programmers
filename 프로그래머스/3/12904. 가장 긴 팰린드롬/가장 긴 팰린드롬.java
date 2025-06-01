class Solution{
    public int solution(String s) {
        int answer = 1;
        
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, expand(i - 1, i + 1, s));
            answer = Math.max(answer, expand(i, i + 1, s));
        }
        
        return answer;
    }
    
    public int expand(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}