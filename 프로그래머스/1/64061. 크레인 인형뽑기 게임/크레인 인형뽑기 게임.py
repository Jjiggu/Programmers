def solution(board, moves):
    cnt = 0
    pop_list = []
    same_number = -1
    rows = len(board)
    new_list = [[] for i in range(rows)] # 공백 리스트
    
    # 각 줄별로 원소 재정렬 
    # 0이면 비어있는거임
    for index, ele in enumerate(board[::-1]):
        for j in range(len(board)):
            if ele[j] != 0:
                new_list[j].append(ele[j])

    # 반복문 돌면서 board[moves 원소 - 1][제일 위 -> :: -1] -> pop() or remove해서 새 stack에 넣기
    for index, ele in enumerate(moves):
        # stack에 같은 숫자 2개 되면 pop() 해서 원소 날린 후 cnt 증가
        if len(new_list[ele - 1]) == 0:
            continue
        else:
            same_number = new_list[ele - 1].pop()
        
        if len(pop_list) == 0:
            pop_list.append(same_number)
            # print(f"공백 리스트에 숫자 추가 : {pop_list}")
        else:
            if same_number == pop_list[-1]:
                pop_list.append(same_number)
                # print(f"숫자 같은 경우 : {pop_list}")
                pop_list.pop()
                pop_list.pop()
                cnt += 2
            else: 
                pop_list.append(same_number)
                # print(f"숫자 다른 경우 : {pop_list}")
    
    return cnt
    # 테케 통과 못하는 이유 -> 숫자가 0인 경우 비어있기 때문에 0이 아닌 수부터 pop() 해야 됨