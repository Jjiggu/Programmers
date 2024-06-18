def solution(s):    
    
    s = s.split()
    result = [int(i) for i in s]
    
    return f"{min(result)} {max(result)}"