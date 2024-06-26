from collections import Counter

def solution(want, number, discount):
    # 딕셔너리 초기화 key:want, value:number
    want_dic = {key:value for key, value in zip(want, number)}
    possible_date = 0
        
    # 없으면 배열 다음 인덱스로
    for i in range(10, len(discount) + 1): # len(want) 만큼 배열 잘라서 순회
        sale_list = discount[i - 10:i]
        
        # if set(sale_list) == set(want): # sale_list에 want 목록이 다 있는지 확인
        if want_dic == dict(Counter(sale_list)): # 있으면 물건 개수 체크
            possible_date += 1
    
    return possible_date