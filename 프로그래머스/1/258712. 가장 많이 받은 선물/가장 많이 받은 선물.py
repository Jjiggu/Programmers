def solution(friends, gifts):
    gift_list = {}
    giver_list = {}
    receiver_list = {}
    answer_list = {}
    
    # friends 등록
    for name1 in friends:
        inner_gift_map = {}
        for name2 in friends:
            inner_gift_map[name2] = 0
        gift_list[name1] = inner_gift_map
        answer_list[name1] = 0
        giver_list[name1] = 0
        receiver_list[name1] = 0
        
    # 선물 관련 데이터 저장
    for gift in gifts:
        giver, receiver = gift.split()
        gift_list[giver][receiver] += 1
        giver_list[giver] += 1
        receiver_list[receiver] += 1
        
    # 선물 비교
    for i in range(len(friends) - 1):
        for j in range(i + 1, len(friends)):
            A = friends[i]
            B = friends[j]
            
            A_count = gift_list[A][B]
            B_count = gift_list[B][A]
            
            if A_count > B_count:
                answer_list[A] += 1
            elif B_count > A_count:
                answer_list[B] += 1
            else:
                A_value = giver_list[A] - receiver_list[A]
                B_value = giver_list[B] - receiver_list[B]
                
                if A_value > B_value:
                    answer_list[A] += 1
                elif A_value < B_value:
                    answer_list[B] += 1
    
    
    
#     # 초기 배열 선언
#     for i in range(len(friends)):
#         for j in range(len(friends)):
#             gift_list[i][j].append(friends[i])
#             gift_list[i][j].append(friend[j])
    
#     # gifts 와 값 비교하여 선물 회수 초기화
#     for name in gifts:
#         for i in range(len(friends)):
#             for j in range(len(friends)):
#                 if gift_list[i][j] == name.strip():
#                     dg_list[i][j].append(int(1)
    
#     # 선물지수
#     for i in range(len(friends)):
#         gift_score.append(sum(dg_list[i][])-sum(dg_list[j][i]))
    
#     answer = 0
    return max(answer_list.values())