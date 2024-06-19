import math

def lcm(a, b):
    return a * b / math.gcd(a, b)

def solution(arr):
    answer = 1
    
    for num in arr:
        answer = int(lcm(answer, num))
    
    
    return answer