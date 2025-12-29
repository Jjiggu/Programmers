class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillArr = skill.toCharArray();
        
        for (String tree : skill_trees) {
            String filtered = filterBySkillOrder(skill, tree);
            if (skill.startsWith(filtered)) answer++;
        }
        
        return answer;
    }
    
    private String filterBySkillOrder(String skill, String tree) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < tree.length(); i++) {
            char alpha = tree.charAt(i);
            if (skill.indexOf(alpha) != -1) sb.append(alpha);
        }
        
        return sb.toString();
    }
}