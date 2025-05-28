import java.util.*;

class Solution {
    
    private static final int SIZE = 50 * 50;
    
    private int[] parent;
    private Map<Integer, String> valueMap;
    private Map<Integer, Set<Integer>> members;
    
    public String[] solution(String[] commands) {
        parent   = new int[SIZE];
        valueMap = new HashMap<>();
        members  = new HashMap<>();
        
        for (int i = 0; i < SIZE; i++) {
            parent[i] = i;
            valueMap.put(i, "EMPTY");
            members.put(i, new HashSet<>(Arrays.asList(i)));
        }
        
        List<String> result = new ArrayList<>();
        
        for (String cmd : commands) {
            String[] p = cmd.split(" ");
            switch (p[0]) {
                case "UPDATE":
                    if (p.length == 4) {
                        handleUpdateCell(
                            Integer.parseInt(p[1]),
                            Integer.parseInt(p[2]),
                            p[3]
                        );
                    } else {
                        handleUpdateValue(p[1], p[2]);
                    }
                    break;
                    
                case "MERGE":
                    handleMerge(
                        Integer.parseInt(p[1]),
                        Integer.parseInt(p[2]),
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4])
                    );
                    break;
                    
                case "UNMERGE":
                    handleUnmerge(
                        Integer.parseInt(p[1]),
                        Integer.parseInt(p[2])
                    );
                    break;
                    
                case "PRINT":
                    handlePrint(
                        Integer.parseInt(p[1]),
                        Integer.parseInt(p[2]),
                        result
                    );
                    break;
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    
    private int toId(int r, int c) {
        return (r - 1) * 50 + (c - 1);
    }
    
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    
    private void handleUpdateCell(int r, int c, String value) {
        int id   = toId(r, c);
        int root = find(id);
        valueMap.put(root, value);
    }
    
    
    private void handleUpdateValue(String val1, String val2) {
        for (Map.Entry<Integer, String> e : valueMap.entrySet()) {
            if (e.getValue().equals(val1)) {
                e.setValue(val2);
            }
        }
    }
    
    
    private void handleMerge(int r1, int c1, int r2, int c2) {
        int id1   = toId(r1, c1);
        int id2   = toId(r2, c2);
        int root1 = find(id1);
        int root2 = find(id2);
        if (root1 == root2) return;
        
        String val1 = valueMap.getOrDefault(root1, "EMPTY");
        String val2 = valueMap.getOrDefault(root2, "EMPTY");
        
        
        for (int m : members.get(root2)) {
            parent[m] = root1;
            members.get(root1).add(m);
        }
        members.remove(root2);
        
        
        if (!val1.equals("EMPTY")) {
            valueMap.put(root1, val1);
        } else {
            valueMap.put(root1, val2);
        }
        valueMap.remove(root2);
    }
    
    
    private void handleUnmerge(int r, int c) {
        int id   = toId(r, c);
        int root = find(id);
        
        
        String preservedValue = valueMap.getOrDefault(root, "EMPTY");
        Set<Integer> group    = new HashSet<>(members.get(root));
        
        
        members.remove(root);
        valueMap.remove(root);
        
        
        for (int m : group) {
            parent[m] = m;
            members.put(m, new HashSet<>(Arrays.asList(m)));
            valueMap.put(m, "EMPTY");
        }
        
        
        valueMap.put(id, preservedValue);
    }
    
    
    private void handlePrint(int r, int c, List<String> result) {
        int id   = toId(r, c);
        int root = find(id);
        result.add(valueMap.getOrDefault(root, "EMPTY"));
    }
}
