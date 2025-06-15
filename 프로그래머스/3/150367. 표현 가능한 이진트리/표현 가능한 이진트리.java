class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            String tree = setLenth(binary);
            
            answer[i] = isValid(tree) ? 1 : 0;
        }
        
        return answer;
    }
    
    private String setLenth(String binary) {
        int len = binary.length();
        int treeHeight = 0;
        
        while((Math.pow(2, treeHeight) - 1) < len) {
            treeHeight++;
        }
        
        int fullLen = (1 << treeHeight) - 1;
        int zeropadding = fullLen - len;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeropadding; i++) sb.append("0");
        sb.append(binary);
        
        return sb.toString();
    }
    
    private boolean isValid(String tree) {
        if(tree.length() == 1) return true;
        
        int mid = tree.length() / 2;
        char root = tree.charAt(mid);
        
        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1);
        
        if (root == '0') {
            if (left.charAt(left.length() / 2) == '1' || right.charAt(right.length() / 2) == '1') return false;
        }
        
        return isValid(left) && isValid(right);
    }
}