def solution(a, b, n):
    answer = 0
    cnt = 0
    
    while(n >= a and n >= 2):
        cnt += (n // a) * b
        n = (n // a)*b + (n % a) 
    
    return cnt