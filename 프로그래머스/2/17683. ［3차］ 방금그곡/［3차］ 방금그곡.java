import java.util.*;

class Solution {
    String[] scale = {"C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B", "B#"};
    Map<String, Integer> scaleMap;
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        
        // #처리를 해줘야하기 때문에 특정 숫자로 변환해서 확인 
        initScale();
        
        List<Integer> target = convertScale(m);
        
        // musicinfos에서 실제 재생된 구간 변환 후 저장 
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            
            int playTime = timeToInt(info[0], info[1]);
            String songName = info[2];
            List<Integer> original = convertScale(info[3]);
            // 실제 재생된 멜로디 생성
            List<Integer> played = makePlayedMelody(original, playTime);
            
            // target이 played 안에 연속 부분수열로 포함되는지 확인
            if (containsMelody(played, target) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = songName;
            }
        }
        
        // 포함되지 않으면 None 반환 
        return answer;
    }
    
    private List<Integer> convertScale(String s) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length();) {
            String key;

            if (i + 1 < s.length() && s.charAt(i + 1) == '#') {
                key = s.substring(i, i + 2);
                i += 2;
            } else {
                key = String.valueOf(s.charAt(i));
                i++;
            }

            Integer value = scaleMap.get(key);
            list.add(value);
        }

        return list;
    }
    
    // 실제 재생된 멜로디 만들기
    private List<Integer> makePlayedMelody(List<Integer> original, int playTime) {
        List<Integer> played = new ArrayList<>();

        for (int i = 0; i < playTime; i++) {
            played.add(original.get(i % original.size()));
        }

        return played;
    }
    
    // played 안에 target이 연속 부분수열로 포함되는지 검사
    private boolean containsMelody(List<Integer> played, List<Integer> target) {
        if (target.size() > played.size()) return false;
        
        for (int i = 0; i <= played.size() - target.size(); i++) {
            boolean same = true;
            
            for (int j = 0; j < target.size(); j++) {
                if (!played.get(i + j).equals(target.get(j))){
                    same = false;
                    break;
                }
            }
            
            if (same) return true;
        }

        return false;
    }
    
    private int timeToInt(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        int endTime = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        int startTime = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        
        return endTime - startTime;
    }
    
    private void initScale() {
        scaleMap = new HashMap<>();
        int idx = 1;
        
        for (String s : scale) scaleMap.put(s, idx++);
    }
}