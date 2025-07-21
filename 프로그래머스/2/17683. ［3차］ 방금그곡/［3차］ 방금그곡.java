import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int bestDur = -1;
        
        Map<String, Integer> toneMap = new HashMap<>();
        String[] tones = {"C","C#","D","D#","E", "E#", "F","F#","G","G#","A","A#","B", "B#"};
        for (int i = 0; i < tones.length; i++) toneMap.put(tones[i], i);
        
        
        String convertM = convert(m, toneMap);
        for (String musicinfo : musicinfos) {
            String[] tmp = musicinfo.split(",");
            
            int dur = calcTime(tmp[0], tmp[1]);
            String title = tmp[2];
            String encPattern = convert(tmp[3], toneMap);
            
            StringBuilder sb = new StringBuilder();
            int times = dur / encPattern.length();
            int rem   = dur % encPattern.length();
            for (int k = 0; k < times; k++) sb.append(encPattern);
            if (rem > 0) sb.append(encPattern, 0, rem);
            String sound = sb.toString();
            
            if (sound.contains(convertM) && dur > bestDur) {
                bestDur = dur;
                answer = title;
            } 
        }
        
        return answer;
    }
    
    private int calcTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        
        return timeToInt(endTime) - timeToInt(startTime);
    }
    
    private int timeToInt(String[] timeArr) {
        int hour = Integer.parseInt(timeArr[0]);
        int min = Integer.parseInt(timeArr[1]);
        
        return hour * 60 + min;
    }
    
    private String convert(String m, Map<String,Integer> toneMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); ) {
            String note = (i+1 < m.length() && m.charAt(i+1)=='#')
                        ? m.substring(i, i+2)
                        : m.substring(i, i+1);
            int idx = toneMap.get(note);        
            sb.append((char)('a' + idx));      
            i += note.length();
        }
        return sb.toString();
    }

    
    private String repeatSound(String pattern, int cnt, int rem) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < cnt; i++) sb.append(pattern);
        
        if (rem > 0) sb.append(pattern.substring(0, rem));
        
        return sb.toString();
    }
}