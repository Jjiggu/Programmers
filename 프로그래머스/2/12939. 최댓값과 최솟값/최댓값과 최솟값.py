def solution(s):    
    s = s.split()
    result = []
    
    for i in s:
        result.append(int(i))
    
    min_num = min(result)
    
    max_num = max(result)
    
    return f"{min_num} {max_num}"