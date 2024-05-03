def solution(cards1, cards2, goal):
    answer = ''
    
    for word in goal:
        if len(cards1) > 0 and word == cards1[0]:
            cards1.pop(0)
        elif len(cards2) > 0 and word == cards2[0]:
            cards2.pop(0)
        else:
            return 'No'
    answer = 'Yes'
    
    # 첫번째 시도
    # for word in goal:
    #     if word in cards1:
    #         if word == cards1[0]:
    #             cards1.pop(0)
    #         else:
    #             answer = 'No'
    #             break
    #     elif word in cards2:
    #         if word == cards2[0]:
    #             cards2.pop(0)
    #         else:
    #             answer = 'No'
    #             break
            
    return 'Yes'