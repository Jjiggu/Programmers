def solution(n):
    result = ""
    watermelon = "수박"
    
    if n % 2 == 0:
        result += watermelon * (n//2)
        return result
    
    else:
        result += watermelon * (n//2)
        result += watermelon[0]
        return result
        