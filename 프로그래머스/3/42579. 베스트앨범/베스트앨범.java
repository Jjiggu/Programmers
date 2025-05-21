import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer, Integer>> sortedGenres = new HashMap<>();
        
        
        for (String genre : genres) {
            sortedGenres.put(genre, new HashMap<>());
        }
        
        
        for (int i = 0; i < genres.length; i++) {
            sortedGenres.get(genres[i]).put(i, plays[i]);
        }
        
        
        Map<String, Integer> allPlays = new HashMap<>();
        
        for (String genre : sortedGenres.keySet()) {
            allPlays.put(genre, sortedGenres.get(genre).values().stream().mapToInt(n -> n).sum());
        }
        
        List<String> keySetList = new ArrayList<>(allPlays.keySet());
        keySetList.sort((o1, o2) -> allPlays.get(o2) - allPlays.get(o1));
        
        
        for (String s : keySetList) {
            Map<Integer, Integer> maps = sortedGenres.get(s);
            List<Integer> idxList = new ArrayList<>(maps.keySet());
            
            idxList.sort((o1, o2) -> maps.get(o2) - maps.get(o1));
            
            if (idxList.size() <= 1) {
                answer.add(idxList.get(0));
            } else {
                answer.add(idxList.get(0));
                answer.add(idxList.get(1));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();         
    }
}