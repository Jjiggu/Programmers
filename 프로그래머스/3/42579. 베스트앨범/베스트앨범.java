import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, Map<Integer, Integer>> sortedGenre = new HashMap<>();
        
        for (String genre : genres) {
            sortedGenre.put(genre, new HashMap<>());
        }
        
        for (int i = 0; i < genres.length; i++) {
            sortedGenre.get(genres[i]).put(i, plays[i]);
        }
        
        for (String s : sortedGenre.keySet()) {
            genreCnt.put(s, sortedGenre.get(s).values().stream().mapToInt(n -> n).sum());
        }
        
        List<String> keySetList = new ArrayList<>(genreCnt.keySet());

        keySetList.sort((o1, o2) -> (genreCnt.get(o2).compareTo(genreCnt.get(o1))));
        
        keySetList.forEach(s -> {
            Map<Integer, Integer> asdf = sortedGenre.get(s);

            List<Integer> integers = new ArrayList<>(asdf.keySet());

            integers.sort((o1, o2) -> (asdf.get(o2).compareTo(asdf.get(o1))));

            if (integers.size() <= 1) {
                answer.add(integers.get(0));
            } else {
                answer.add(integers.get(0));
                answer.add(integers.get(1));
            }
        });

        return answer.stream().mapToInt(i -> i).toArray();
    }
}