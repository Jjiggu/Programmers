def solution(n):
    answer = 0
    three_n = ''

    while(n > 0):
        three_n += str(n % 3 )
        n = n // 3
        
    for index, num in enumerate(three_n):
        answer += int(num) * pow(3, len(three_n) - index - 1)
        
    return answer