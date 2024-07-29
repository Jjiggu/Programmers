from collections import Counter

def solution(topping):
    cnt = 0
    big_bro = Counter(topping)
    little_bro = set()
    
    for i in topping:
        big_bro[i] -= 1
        if big_bro[i] == 0:
            del big_bro[i]
        
        little_bro.add(i)
        if len(big_bro) == len(little_bro):
            cnt += 1
    
    return cnt