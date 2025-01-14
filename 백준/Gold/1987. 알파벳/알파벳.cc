#include <iostream>
#include <cmath>

using namespace std;

int R, C;
int map[21][21];
int cntMap[21][21];
int check[26]; // check 배열 크기 26으로 수정 (알파벳 A-Z)
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int answer;

void backTracking(int y, int x) {
    answer = max(answer, cntMap[y][x]);
    
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        
        if (ny < 0 || nx < 0 || ny >= R || nx >= C)
            continue;
        
        // 알파벳이 아직 사용되지 않았다면
        if (!check[map[ny][nx]]) {
            check[map[ny][nx]] = 1; // 해당 알파벳을 사용함
            cntMap[ny][nx] = cntMap[y][x] + 1; // 경로 길이 증가
            backTracking(ny, nx); // 재귀 호출
            cntMap[ny][nx] = 0; // 백트래킹: 경로 길이 초기화
            check[map[ny][nx]] = 0; // 백트래킹: 알파벳 사용 여부 초기화
        }
    }
}

int main(void) {
    cin >> R >> C;

    // 맵 입력 받기
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            char input;
            cin >> input;
            map[i][j] = input - 'A';  // 알파벳을 0~25의 숫자로 변환
        }
    }

    // (0, 0)에서 시작, 해당 알파벳 사용 표시
    check[map[0][0]] = 1;
    cntMap[0][0] = 1;  // 경로 길이 1부터 시작

    // 백트래킹 시작
    backTracking(0, 0);

    // 자바 코드와 동일하게 경로 길이를 출력
    cout << answer << endl;

    return 0;
}
