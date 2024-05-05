def solution(number, limit, power):
    answer = 0
    
    measure_list = []
    measure_count = 0
    
#     for j in range(1, int(i**(1/2)) + 1):
#         if (i % j == 0):
#             measure_count += 1
#             if ( (j**2) != i) : 
#                 measure_count += 1

    
    # 1~number까지 약수 구하는 로직
    for i in range(1, number+1): # number에 있는 숫자 차례대로 뽑기
        for j in range(1, int(i**(1/2)) + 1):
            if (i % j == 0):
                measure_count += 1
                if ( (j**2) != i) : 
                    measure_count += 1
        # for j in range(1, i + 1): # i 까지 돌면서 약수 확인
        #     if i % j == 0:
        #         measure_count += 1
                
        measure_list.append(measure_count)
        measure_count = 0
    
    # mesure_list 돌면서 limit 보다 크면 power으로 변경
    for index, el in enumerate(measure_list):
        if el > limit:
            measure_list[index] = power
            
    # measure_list 합을 answer로 저장
    answer = sum(measure_list)
    
    return answer