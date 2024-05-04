def solution(k, score):
    answer = []
    
    greate_list = []
    result = []
    
    for i in score:
        if len(greate_list) < k:
            greate_list.append(i)
        else:
            if i > min(greate_list):
                greate_list.remove(min(greate_list))
                greate_list.append(i)
        
        result.append(min(greate_list))
    
    return result