def solution(x, n):
    result = []
    now_num = 0
    for _ in range(n):
        result.append(now_num + x)
        now_num += x
    return result