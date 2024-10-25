import java.util.Arrays;

class Solution {
    public String solution(String[] seoul) {
        int kimIndex = Arrays.asList(seoul).indexOf("Kim");
        String result = String.format("김서방은 %d에 있다", kimIndex);
        
        return result;
    }
}