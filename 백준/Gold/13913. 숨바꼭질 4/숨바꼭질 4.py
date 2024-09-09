from collections import deque

N, K = map(int, input().split())
MAX = 100001
dist = [0] * MAX
move = [0] * MAX
result = []

def path(x):
    arr = []
    tmp = x

    for _ in range(dist[x] + 1):
        arr.append(tmp)
        tmp = move[tmp]

    return ' '.join(map(str, arr[::-1]))

def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        x = queue.popleft()

        if x == K:
            print(dist[x])
            print(path(x))
            return

        for nx in (x - 1, x + 1, x * 2):
            if 0 <= nx < MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                queue.append(nx)
                move[nx] = x


bfs(N)
