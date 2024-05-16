def solution(players, callings):
    answer = []
    
    players_map = {}
    # index 맵 생성
    for index, player in enumerate(players):
        players_map[player] = index
        
    # callings 배열 순회하며 나온 값의 인덱스 확인
    for name in callings:
        # now_index = players.index(name)
        now_index = players_map[name]
        pre_index = now_index - 1
        
        # 앞자리와 순서 변경
        pre_word = players[pre_index]
        players[pre_index] = name
        players[now_index] = pre_word
        
        # map 갱신
        players_map[name] = pre_index
        players_map[pre_word] = now_index
    
    return players