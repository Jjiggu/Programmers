import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {

        Map<String, List<Integer>> idx = new HashMap<>();
        for (String inf : info) {
            String[] parts = inf.split(" ");
            String[] attrs = Arrays.copyOf(parts, 4);
            int score = Integer.parseInt(parts[4]);
            
            for (int mask = 0; mask < (1 << 4); mask++) {
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) {
                        key.append('-');
                    } else {
                        key.append(attrs[i]);
                    }
                    if (i < 3) key.append(' ');
                }
                String k = key.toString();
                idx.computeIfAbsent(k, z -> new ArrayList<>()).add(score);
            }
        }
        
        for (List<Integer> list : idx.values()) {
            Collections.sort(list);
        }

        int Q = query.length;
        int[] answer = new int[Q];
        for (int qi = 0; qi < Q; qi++) {
            String q = query[qi]
                        .replaceAll(" and ", " ")
                        .trim();
            String[] parts = q.split(" ");
            String key = String.join(" ",
                             parts[0], parts[1], parts[2], parts[3]);
            int target = Integer.parseInt(parts[4]);

            List<Integer> list = idx.getOrDefault(key, Collections.emptyList());

            int lo = 0, hi = list.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (list.get(mid) < target) lo = mid + 1;
                else                         hi = mid;
            }
            answer[qi] = list.size() - lo;
        }
        return answer;
    }
}
