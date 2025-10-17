import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        Map<String, List<Integer>> infoMap = preProcess(info);
        
        int n = query.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            String q = query[i].replaceAll(" and ", " ").trim();
            String[] parts = q.split(" ");
            String key = String.join(" ", parts[0], parts[1], parts[2], parts[3]);
            int target = Integer.parseInt(parts[4]);
            
            List<Integer> list = infoMap.getOrDefault(key, Collections.emptyList());
            
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            answer[i] = list.size() - left;
        }
        
        return answer;
    }
    
    private Map<String, List<Integer>> preProcess(String[] info) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (String s : info) {
            String[] userInfo = s.split(" ");
            String[] attr = Arrays.copyOf(userInfo, 4);
            int score = Integer.parseInt(userInfo[4]);
            
            for (int mask = 0; mask < (1 << 4); mask++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) {
                        sb.append('-');
                    } else {
                        sb.append(attr[i]);
                    }
                    if (i < 3) sb.append(' ');
                }
                String key = sb.toString();
                map.computeIfAbsent(key, o1 -> new ArrayList<>()).add(score);
            }
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        return map;
    }
}
