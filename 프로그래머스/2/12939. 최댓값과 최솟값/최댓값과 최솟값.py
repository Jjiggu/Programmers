def solution(s):    
    s = s.split(" ")
    sorted_s = sorted([int(i) for i in s])
    
    return f"{min(sorted_s)} {max(sorted_s)}"