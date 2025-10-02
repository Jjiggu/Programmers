import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> arr1 = makeSet(str1);
        List<String> arr2 = makeSet(str2);

        // 교집합 구하기 (arr2를 복사해서 소모해가며 카운트)
        List<String> temp = new ArrayList<>(arr2);
        int intersection = 0;
        for (String s : arr1) {
            if (temp.contains(s)) {
                intersection++;
                temp.remove(s); // arr2에서 하나 소모
            }
        }

        // 합집합 = 전체 크기 합 - 교집합
        int union = arr1.size() + arr2.size() - intersection;

        if (union == 0) return 65536; // 둘 다 공집합일 때

        return (int) ((double) intersection / union * 65536);
    }
    
    private List<String> makeSet(String str) {
        str = str.toLowerCase();
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                arr.add("" + c1 + c2);
            }
        }
        
        return arr;
    }
}
