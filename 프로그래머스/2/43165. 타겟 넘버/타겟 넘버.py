def solution(numbers, target):
    answer = 0
    result = [0]
    
    for i in range(len(numbers)):
        tmp = []
        for j in range(len(result)):
            tmp.append(result[j] + numbers[i])
            tmp.append(result[j] - numbers[i])
        
        result = tmp
    
    answer = result.count(target)
    
    return answer