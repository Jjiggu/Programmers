import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems)); // 보석 종류 개수 확인
        int totalTypes = gemTypes.size(); // 전체 보석 종류 수

        Map<String, Integer> gemCount = new HashMap<>(); // 현재 구간의 보석 개수 저장
        int left = 0, right = 0; // 투 포인터 초기화
        int minLen = Integer.MAX_VALUE;
        int[] answer = {0, gems.length - 1}; // 기본 값 설정

        while (right < gems.length) {
            // 오른쪽 포인터 확장 (보석 추가)
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++; 

            // 현재 구간이 모든 보석을 포함하면 왼쪽 포인터 이동하여 최소 길이 찾기
            while (gemCount.size() == totalTypes) {
                if (right - left < minLen) { // 현재 구간이 최소 길이라면 갱신
                    minLen = right - left;
                    answer[0] = left + 1; // 문제 요구사항이 1-based index
                    answer[1] = right;
                }

                // 왼쪽 포인터 이동하여 구간 축소
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]); // 개수가 0이면 제거
                }
                left++; // 왼쪽 포인터 증가
            }
        }

        return answer;
    }
}
