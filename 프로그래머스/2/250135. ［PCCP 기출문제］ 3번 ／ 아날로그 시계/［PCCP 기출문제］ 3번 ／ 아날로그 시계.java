class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        
        answer = cal(endTime) - cal(startTime) + (alramNow(startTime)? 1 : 0); 
        
        return answer;
    }
    
    static int cal(int time){
        int sm = time * 59 / 3600; 
        int sh = time * 719 / 43200;  
        int a = 43200 <= time ? 2 : 1; 
                                      
        return sm + sh - a;
    }
    
    private boolean alramNow(int time){
        return time * 59 % 3600 == 0 || time * 719 % 43200 == 0; 
    }
}