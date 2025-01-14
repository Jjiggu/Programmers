#include <iostream>
#include <cmath>

using namespace std;

int R, C;
int map[21][21];
int cntMap[21][21];
int check[26];
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
        
        if (!check[map[ny][nx]]) {
            check[map[ny][nx]] = 1;
            cntMap[ny][nx] = cntMap[y][x] + 1;
            backTracking(ny, nx); 
            cntMap[ny][nx] = 0;
            check[map[ny][nx]] = 0;
        }
    }
}

int main(void) {
    cin >> R >> C;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            char input;
            cin >> input;
            map[i][j] = input - 'A'; 
        }
    }

    check[map[0][0]] = 1;

    backTracking(0, 0);

    cout << answer + 1;

    return 0;
}
