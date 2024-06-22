def solution(n,a,b):
    answer = 0
    
    # 2로 나누었을때 몫이 같으면 만난거임
    # 홀수 = (홀수 + 1) // 2, 짝수 = 짝수 // 2
    while(a != b):
        if a % 2 == 1:
            a = (a + 1) // 2
        else:
            a = a // 2
            
        if b % 2 == 1:
            b = (b + 1) // 2
        else:
            b = b // 2
        
        answer += 1
    
    return answer