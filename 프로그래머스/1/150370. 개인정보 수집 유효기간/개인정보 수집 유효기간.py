def check_day(expiration_date, today):
    if expiration_date[0] > today[0]:
        return True
    if expiration_date[0] == today[0] and expiration_date[1] > today[1]:
        return True
    
    if expiration_date[0] == today[0] and expiration_date[1] == today[1] and expiration_date[2] > today[2]:
        return True
    
    return False


def solution(today, terms, privacies):
    result = []
    i = 1
    # result_terms = []
    # privacies_terms = []
    
    terms_map = dict()
    privacies_map = dict()
    
    today = list(map(int, today.split(".")))
    
    # terms 를 딕셔너리로 저장
#     for term in terms:
#         result_terms.append(term.split(" "))
        
#     for i, j in result_terms:
#         terms_map[i] = j
# 아래처럼 한 줄로 변경 가능
    expiration = {term[0]:int(term[2:]) for term in terms}
        
    # privacies를 딕셔너리로 저장
    for pri in privacies:
        pri = pri.split(" ")
        pri_date = list(map(int, pri[0].split(".")))
        
        pri_date[1] += expiration[pri[1]]
        
        if pri_date[1] > 12:
            if pri_date[1] % 12 == 0:
                pri_date[0] += (pri_date[1]//12) -1
                pri_date[1] = 12
            else:
                pri_date[0] += pri_date[1] // 12 
                pri_date[1] %= 12
            
        # 약관유형 확인 후 날짜 계산해서 today보다 큰 지 확인
        if check_day(pri_date, today) == False:
            result.append(i)
        
        i += 1
    
    # 크면 result에 추가
    return result