def solution(d, budget):
    cnt = 0
    d = sorted(d)
    new_budget = budget
    
    for i in d:
        new_budget -= i
        if new_budget >= 0:
            cnt += 1
            
        elif budget < 0:
            break
    
    return cnt
        