def solution(n):
    next_n = n + 1
    
    n_cnt = bin(n).count('1') 
    result_cnt = 0
    
    while(True):
        if n_cnt == bin(next_n).count('1'):
            return next_n
        
        next_n += 1 
        