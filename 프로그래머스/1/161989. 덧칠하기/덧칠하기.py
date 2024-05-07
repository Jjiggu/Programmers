def solution(n, m, section):
    answer = 0
    
    # section[0]은 무조건 칠해야 함 -> 시작점을 section[0]으로 설정하고 count도 1로 초기화
    start_point = section[0]
    count = 1

    for i in section:
        # 다음 섹션은 start_point + m 보다 큰 섹션에서 시작해야 함 -> 보다 작으면 같은 곳을 중복해서 칠하는것이라 최소 횟수 x
        if start_point + (m - 1) < i:
            start_point = i
            count += 1

    # 배열이 모두 칠한 상태가 되면 끝
    return count