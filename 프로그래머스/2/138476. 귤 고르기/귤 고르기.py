def solution(k, tangerine):
    cnt = 0
    tan_dic = {i:0 for i in tangerine} # tangerine에 있는 원소로 딕셔너리 초기화
    
    for i in tangerine: # tangerine 원소 빈도 저장
        tan_dic[i] += 1
    
    tan_dic = sorted(tan_dic.items(), reverse=True, key=lambda item: item[1]) # 내림차순으로 정렬 -> 큰 원소부터 넣어야 귤 종류가 최소가 될 수 있음
    
    mandarin_sum = 0 # 귤 개수 초기화
    
    for i in tan_dic:
        mandarin_sum += i[1]
        
        if mandarin_sum >= k:
            cnt += 1
            return cnt
        
        cnt += 1