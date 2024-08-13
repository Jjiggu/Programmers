def solution(name, yearning, photo):
    score_dict = {key:value for key, value in zip(name, yearning)}
    result = []
    
    for i in photo:
        score = 0
        for j in i:
            try:
                score += score_dict[j]
                
            except:
                score += 0
                
        result.append(score)
    
    return result