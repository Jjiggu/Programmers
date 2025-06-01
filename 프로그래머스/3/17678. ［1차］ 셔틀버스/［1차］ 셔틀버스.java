import java.util.*;

class Solution {
    static final int START_TIME = 540;
    
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        int[] times = new int[timetable.length];
        
        for (int i = 0; i < timetable.length; i++) {
            times[i] = stringToTime(timetable[i]);
        }
        
        Arrays.sort(times);
        
        int depart = START_TIME;
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            int boardingCnt = 0;
            
            while (boardingCnt < m && idx < times.length && times[idx] <= depart) {
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
        
        return timeTostring(answer);
    }   
    
    private int stringToTime(String time) {
        String[] arr = time.split(":");

        int hour = Integer.parseInt(arr[0]) * 60;
        int min = Integer.parseInt(arr[1]);
        
        return hour + min;
    }
    
    private String timeTostring(int time) {
        int hour = time / 60;
        int min = time % 60;;
        
        return String.format("%02d:%02d", hour, min);
    }
}
