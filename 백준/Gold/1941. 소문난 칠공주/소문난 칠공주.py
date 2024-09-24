from collections import deque

# 5x5 지도 입력
maps = [list(input().strip()) for _ in range(5)]
visited = [[0] * 5 for _ in range(5)]
cnt = 0

def comb(depth, start):
    global cnt

    if depth == 7:
        if bfs():
            cnt += 1
        return

    for i in range(start, 25):
        x = i // 5
        y = i % 5
        if visited[x][y] == 0:
            visited[x][y] = 1
            comb(depth + 1, i + 1)
            visited[x][y] = 0

def bfs():
    som = 0
    doyeon = 0
    q = deque()
    visited_map = [[0] * 5 for _ in range(5)]
    
    # 첫 번째 선택된 셀 찾기
    found = False
    for i in range(5):
        for j in range(5):
            if visited[i][j] == 1:
                q.append((i, j))
                visited_map[i][j] = 1
                if maps[i][j] == 'S':
                    som += 1
                else:
                    doyeon += 1
                found = True
                break
        if found:
            break
    
    # 선택된 셀이 없으면 연결 불가
    if not found:
        return False

    count = 1
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < 5 and 0 <= ny < 5 and visited[nx][ny] == 1 and visited_map[nx][ny] == 0:
                visited_map[nx][ny] = 1
                q.append((nx, ny))
                count += 1
                if maps[nx][ny] == 'S':
                    som += 1
                else:
                    doyeon += 1

    # 연결된 셀의 수가 7이고 'S'가 4개 이상인지 확인
    if count == 7 and som >= 4:
        return True
    else:
        return False

# 조합 생성 및 검증 시작
comb(0, 0)
print(cnt)
