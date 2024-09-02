def solution(friends, gifts):
    give = {i:[] for i in friends}
    receive = {i:[] for i in friends}
    gift_pont = {i:0 for i in friends}
    
    # gift_list = [[0] * len(friends)] * len(friends)
    gift_list = [[0] * len(friends) for i in range(len(friends))]
    
    friend_num = {}
    
    result = [0] * len(friends)
    
    for idx, friend in enumerate(friends):
        friend_num[friend] = idx
    
    for i in range(len(gifts)):
        giver, reciever = gifts[i].split(" ")
        
        gift_list[friend_num[giver]][friend_num[reciever]] += 1
        
        give[giver].append(reciever)
        receive[reciever].append(giver)
    
    
    for g, r, name in zip(give.values(), receive.values(), friends):
        gift_pont[name] = len(g) - len(r)
        
    
    for i in range(len(friends)):
        for j in range(len(friends)):
            if gift_list[i][j] > gift_list[j][i]:
                result[i] += 1
            
            elif gift_list[i][j] == gift_list[j][i]:
                if gift_pont[friends[i]] > gift_pont[friends[j]]:
                    result[i] += 1
    
    return max(result)
    