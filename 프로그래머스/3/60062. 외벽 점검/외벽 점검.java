import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int wLen = weak.length;
        int answer = dist.length + 1;  // 최솟값 비교용 초기화

        // 1) weak 배열을 리스트로 변환
        List<Integer> weakList = new ArrayList<>();
        for (int w : weak) {
            weakList.add(w);
        }
        // 2) 원형→선형 변환
        List<Integer> extended = extendWeak(n, weakList);

        // 3) dist 순열 하나하나 생성
        List<List<Integer>> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        // 4) 각 순열과 각 시작점(i)마다 필요한 친구 수 계산
        for (List<Integer> perm : permutations) {
            for (int start = 0; start < wLen; start++) {
                int count = 1;  // 투입할 친구 수
                // 첫 번째 친구가 커버할 수 있는 끝 지점
                int position = extended.get(start) + perm.get(0);

                // 다음 약한 지점부터 확인
                for (int idx = start + 1; idx < start + wLen; idx++) {
                    if (extended.get(idx) > position) {
                        // 현재 친구로 커버 불가능 → 다음 친구 투입
                        count++;
                        if (count > dist.length) break;  // 친구 부족
                        position = extended.get(idx) + perm.get(count - 1);
                    }
                }
                answer = Math.min(answer, count);
            }
        }

        if (answer > dist.length) return -1;
        return answer;
    }

    // 원형 weak → 선형 extended 변환
    private List<Integer> extendWeak(int n, List<Integer> weakList) {
        List<Integer> extended = new ArrayList<>(weakList);
        int originalSize = weakList.size();
        for (int i = 0; i < originalSize; i++) {
            extended.add(weakList.get(i) + n);
        }
        return extended;
    }

    // dist 배열의 순열을 재귀로 생성
    private void permute(int[] arr, int idx, List<List<Integer>> result) {
        if (idx == arr.length) {
            // 완성된 순열을 List<Integer>로 복사하여 저장
            List<Integer> perm = new ArrayList<>();
            for (int v : arr) perm.add(v);
            result.add(perm);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permute(arr, idx + 1, result);
            swap(arr, idx, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
