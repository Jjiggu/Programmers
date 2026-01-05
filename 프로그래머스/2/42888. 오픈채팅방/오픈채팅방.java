import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        
        for (String r : record) {
            String[] s = r.split(" ");
            if (s[0].equals("Enter")) {
                map.put(s[1], s[2]);
            } else if (s[0].equals("Change")) {
                map.put(s[1], s[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] s = r.split(" ");
            if (s[0].equals("Enter")) {
                answer.add(map.get(s[1]) + "님이 들어왔습니다.");
            } else if (s[0].equals("Leave")) {
                answer.add(map.get(s[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}