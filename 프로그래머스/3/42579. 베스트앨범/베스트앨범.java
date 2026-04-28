import java.util.*;

class Solution {
    
    Map<String, Map<Integer, Integer>> soretedGenres = new HashMap<>();
    Map<String, Integer> allPlays = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        record(genres, plays);
        sumPlays();
        
        List<String> keySetList = new ArrayList<>(allPlays.keySet());
        keySetList.sort((o1, o2) -> allPlays.get(o2) - allPlays.get(o1));
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : keySetList) {
            Map<Integer, Integer> maps = soretedGenres.get(genre);
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
    
    private void record(String[] genres, int[] plays) {
        for (String genre : genres) soretedGenres.put(genre, new HashMap<>());
        for (int i = 0; i < genres.length; i++) soretedGenres.get(genres[i]).put(i, plays[i]);
    }
    
    private void sumPlays() {
        for (String genre : soretedGenres.keySet()) allPlays.put(genre, soretedGenres.get(genre).values().stream().mapToInt(n -> n).sum());
    }
}