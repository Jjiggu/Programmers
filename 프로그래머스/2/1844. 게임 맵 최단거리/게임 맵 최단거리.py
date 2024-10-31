from collections import deque

def bfs(start, end, maps):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    n, m = len(maps), len(maps[0])
    
    visited = [[False] * len(maps[0]) for _ in maps]
    
    q = deque()
    q.append((start[0], start[1], 1))  # 시작 좌표와 거리(1)
    
    while q:
        x, y, dist = q.popleft()
        
        if (x, y) == end:
            return dist
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]    
            
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and maps[nx][ny] == 1:
                    q.append((nx, ny, dist + 1))
                    visited[nx][ny] = True
    
    return -1  # 도착 지점에 도달할 수 없는 경우

def solution(maps):
    maps_n = len(maps)
    maps_m = len(maps[0])
    
    answer = bfs((0, 0), (maps_n - 1, maps_m - 1), maps)
    
    return answer
