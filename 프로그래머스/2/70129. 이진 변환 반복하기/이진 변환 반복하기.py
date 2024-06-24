def solution(s):
    result = []
    zero_cnt = 0
    trans_cnt = 0

    
    while(s != '1'): # "1"이 될때까지 반복
        zero_cnt += s.count("0")
        
        s = bin(s.count("1"))[2:]
        
        trans_cnt += 1
    
    return [trans_cnt, zero_cnt]