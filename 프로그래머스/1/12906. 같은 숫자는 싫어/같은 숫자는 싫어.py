def solution(arr):
    answer = []
    temp = -1
    
    for i in arr:
        if answer[-1:] == [i]:
            continue
        answer.append(i)
        # if i == temp:
        #     continue
        # else:
        #     answer.append(i)
        #     temp = i
            
    return answer