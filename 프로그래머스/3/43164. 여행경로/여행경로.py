from collections import defaultdict

def solution(tickets):
    t_dict = defaultdict(list)
    # result = sorted(tickets, key = lambda x: ((x[0], x[1])))

    for s, e in tickets:  # tickets 원소들을 출발 공항을 key, 도착 공항을 value로 저장
        t_dict[s].append(e)
    
    for t_key in t_dict.keys():  # 도착 공항 리스트를 내림차순으로 정렬 -> pop() 해서 사용할 예정이라 
        t_dict[t_key].sort(reverse = True)
    
    answer = []
    path = ["ICN"]  # 출발지 "ICN" 
    
    while path:  # DFS 실행
        now = path[-1]
        
        if now not in t_dict or len(t_dict[now]) == 0:  # 이어지는 공항이 없는 경우와 이미 항공권을 사용한 경우
            answer.append(path.pop())  # 위 조건을 만족할 경우 정답인 경로
        else:  # now에서 출발하는 항공편 path에 추가
            path.append(t_dict[now].pop())
        print(path)
    return answer[::-1]  # 내림차순으로 정렬했기 때문에 뒤집어서 return 
    