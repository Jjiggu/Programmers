import java.util.*;

class Solution {
    static final int SIZE = 51; // 1-based 인덱스, 50까지

    public String[] solution(String[] commands) {
        int[][] merged = new int[SIZE][SIZE]; // 병합 그룹 대표 좌표를 1차원 인덱스로 저장
        String[][] content = new String[SIZE][SIZE];

        // 초기화: 각 셀이 자기 자신이 대표, 내용은 EMPTY
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                merged[i][j] = i * SIZE + j;
                content[i][j] = "EMPTY";
            }
        }

        List<String> answer = new ArrayList<>();

        for (String cmd : commands) {
            String[] parts = cmd.split(" ");
            if (parts[0].equals("UPDATE")) {
                if (parts.length == 4) {
                    int r = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);
                    String value = parts[3];
                    int group = merged[r][c];
                    // 병합 그룹 전체 값을 바꿔준다
                    for (int i = 1; i < SIZE; i++) {
                        for (int j = 1; j < SIZE; j++) {
                            if (merged[i][j] == group) {
                                content[i][j] = value;
                            }
                        }
                    }
                } else { // UPDATE value1 value2
                    String value1 = parts[1];
                    String value2 = parts[2];
                    for (int i = 1; i < SIZE; i++) {
                        for (int j = 1; j < SIZE; j++) {
                            if (content[i][j].equals(value1)) {
                                content[i][j] = value2;
                            }
                        }
                    }
                }
            } else if (parts[0].equals("MERGE")) {
                int r1 = Integer.parseInt(parts[1]);
                int c1 = Integer.parseInt(parts[2]);
                int r2 = Integer.parseInt(parts[3]);
                int c2 = Integer.parseInt(parts[4]);
                if (r1 == r2 && c1 == c2) continue; // 자기 자신과 병합은 무시

                int group1 = merged[r1][c1];
                int group2 = merged[r2][c2];

                // 병합 시 대표 선택(둘 중 한 그룹으로 통합)
                String newValue = !content[r1][c1].equals("EMPTY") ? content[r1][c1] : content[r2][c2];

                for (int i = 1; i < SIZE; i++) {
                    for (int j = 1; j < SIZE; j++) {
                        if (merged[i][j] == group2) {
                            merged[i][j] = group1;
                        }
                    }
                }
                // 병합된 그룹 전체 값을 newValue로 변경
                for (int i = 1; i < SIZE; i++) {
                    for (int j = 1; j < SIZE; j++) {
                        if (merged[i][j] == group1) {
                            content[i][j] = newValue;
                        }
                    }
                }
            } else if (parts[0].equals("UNMERGE")) {
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                int group = merged[r][c];
                String cellValue = content[r][c];
                // 병합된 모든 셀을 분리
                for (int i = 1; i < SIZE; i++) {
                    for (int j = 1; j < SIZE; j++) {
                        if (merged[i][j] == group) {
                            merged[i][j] = i * SIZE + j;
                            content[i][j] = "EMPTY";
                        }
                    }
                }
                // 단, 해제된 셀(r,c)는 원래 값으로 복원
                content[r][c] = cellValue;
            } else if (parts[0].equals("PRINT")) {
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                answer.add(content[r][c]);
            }
        }

        return answer.toArray(new String[0]);
    }
}
