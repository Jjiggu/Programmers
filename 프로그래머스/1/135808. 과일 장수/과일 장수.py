def solution(k, m, score):
    score_list = score
    num_box = len(score) // m
    score_sum = 0
    
    # score를 내림차순으로 정렬
    score_list.sort(reverse=True)
    
    # m개씩 나누기 len(score) // m 해서 나온만큼만
    for i in range(num_box):
        box = score_list[m*i:m*(i+1)]
        
        score_sum += box[-1] * m
    
    # m개씩 나눈 후 sum에 추가
    return score_sum