def solution(name, yearning, photo):
    answer = []
    name_list = []
    
    name_score = dict(zip(name, yearning))
    
    for p in photo:
        photo_sum = 0
        
        for p_name in p:
            
            photo_sum += name_score.get(p_name, 0)
    
        answer.append(photo_sum)
    
    return answer