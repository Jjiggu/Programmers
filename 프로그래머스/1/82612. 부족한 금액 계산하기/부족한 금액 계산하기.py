def solution(price, money, count):
    answer = -1
    result = 0
    
    for i in range(1, count + 1):
        result += i * price
    
    if result > money:
        return result - money
    else:
        return 0