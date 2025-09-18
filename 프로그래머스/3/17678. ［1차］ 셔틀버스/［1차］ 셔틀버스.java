import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int depart = 540;
        int answer = 0;
        
        int[] times = new int[timetable.length];
        
        for (int i = 0; i < timetable.length; i++) {
            times[i] = timeToInt(timetable[i]);
        }
        
        Arrays.sort(times);
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            int boardingCnt = 0;
            
            while (boardingCnt < m && idx < times.length && times[idx] <= depart) {
                // 탑승하는 사람 수 계산
                boardingCnt++;
                idx++;
            }      
            
            if (i == n - 1) {
                if (boardingCnt < m) {
                    answer = depart;
                } else {
                    answer = times[idx - 1] - 1;
                }
            }
            
            depart += t;
        }
        
        return IntToTime(answer);
    }
    
    private String IntToTime(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
    
    private int timeToInt(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
