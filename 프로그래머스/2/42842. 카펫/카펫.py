def solution(brown, yellow):
    answer = []
    
    # 갈색블럭의 개수는 2(n + m) / 2
    # 노란색은 n * m
    # 가로 길이는 세로 길이와 같거나 길다
    nm_range = int((brown - 4) / 2)
    
    for i in range(nm_range):
        if i * (nm_range - i) == yellow:
            answer.append(i + 2)
            answer.append(nm_range - i + 2)
            break
    
    
    return sorted(answer, reverse=True)