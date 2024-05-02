def solution(cards1, cards2, goal):
    answer = 'Yes'
    result = []
    
    for word in goal:
        if word in cards1:
            if word == cards1[0]:
                cards1.pop(0)
            else:
                answer = 'No'
                break
        elif word in cards2:
            if word == cards2[0]:
                cards2.pop(0)
            else:
                answer = 'No'
                break
            
    return answer