def solution(n, m, section):
    answer = 0
    
    count = 1
    start_point = section[0]
    
    # 칠한지 안칠한지 확인하는 배열 생성 (칠하면 : 1, 안칠하면 : 0)

        
    # section의 처음부터 m길이 만큼 탐색하여 칠하지 않은 경우에는 칠함으로 변경 count +1
    # 한 번 칠한 뒤 다음 구역을 어떻게 구할건지?
    for i in section:
        if start_point + (m - 1) < i:
            start_point = i
            count += 1

    # 배열이 모두 칠한 상태가 되면 끝
    return count