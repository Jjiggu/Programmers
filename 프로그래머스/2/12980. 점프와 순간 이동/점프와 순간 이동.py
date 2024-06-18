def solution(n):
    battery = 0
    # 이동 후 홀 짝 기준으로 이동 방법 변경
    while n:
        if (n % 2) == 0:
            n = n // 2
        else:
            battery += 1
            n = (n - 1) // 2

    return battery