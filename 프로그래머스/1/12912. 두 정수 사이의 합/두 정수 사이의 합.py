def solution(a, b):
    # if a == b:
    #     return a
    # else:
    #     result = 0
    #     for i in range(min(a, b), max(a, b) + 1):
    #         result += i
    
    if a > b:
        a, b = b, a
    return sum(range(a, b + 1))