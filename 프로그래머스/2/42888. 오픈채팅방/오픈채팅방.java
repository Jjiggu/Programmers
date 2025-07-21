import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();
        
        for (String r : record) {
            String[] tmp = r.split(" ");
            if (tmp[0].equals("Enter")) {
                name.put(tmp[1], tmp[2]);   
            } else if (tmp[0].equals("Change")) {
                name.put(tmp[1], tmp[2]);
            }
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] tmp = r.split(" ");
            if (tmp[0].equals("Enter")) {
                answer.add(name.get(tmp[1]) + "님이 들어왔습니다.");
            } else if (tmp[0].equals("Leave")) {
                answer.add(name.get(tmp[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}