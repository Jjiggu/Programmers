def solution(spell, dic):
    # 단어가 존재하면 1, 단어가 존재하지 않으면 2
    result = []
    answer = 0
    
    for word in dic:
        if len(spell) == len(word):
                result.append(word)
    for word in result:
        cnt = 0
        for sp in spell:
            if sp in word:
                cnt+=1
        if cnt == len(spell):
            answer += 1
    
    if answer == 0:
        return 2
    else:
        return 1
    
    