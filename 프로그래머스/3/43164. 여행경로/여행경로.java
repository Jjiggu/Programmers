import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        boolean[] visited = new boolean[tickets.length];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");

        List<String> result = dfs("ICN", tickets, path, visited);
        
        return result.toArray(new String[0]);
    }

    
    public List<String> dfs(String cur, String[][] tickets, List<String> path, boolean[] visited) {
        if (path.size() == tickets.length + 1) {
            return new ArrayList<>(path);
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                List<String> result = dfs(tickets[i][1], tickets, path, visited);
                
                if (result != null) return result;
                
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

        return null;
    }
}
