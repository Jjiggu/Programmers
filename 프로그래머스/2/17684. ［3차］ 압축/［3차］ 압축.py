def solution(msg):
    index_dict = {chr(i) : i - 64 for i in range(65, 91)}
    answer = []
    tmp = 0
    
    
    while True:
        if msg in index_dict:
            answer.append(index_dict[msg])
            break
        
        for i in range(1, len(msg) + 1):
            if msg[0:i] not in index_dict:
                answer.append(index_dict[msg[0:i - 1]])
                index_dict[msg[0:i]] = len(index_dict) + 1
                msg = msg[i-1:]
                break
    
    # 첫 글자 받은 후 index 하나씩 올려가며 제일 긴 문자열 찾기
#     while tmp < len(msg):
#         for i in range(tmp, len(msg) + 1):
#             word = msg[tmp:i]
#             if word not in index_dict:
#                 print(word)
#                 tmp = i
#                 break
            
            
        
#         while len(word) < len(msg) + 1 and word in index_dict:
#             word += msg[tmp + n]
#             print(word)
#             n += 1
        
#         # 문자열을 찾았다면 색인 번호 출력하고 입력에서 제거
#         answer.append(index_dict[word])
        
#         # 입력의 길이가 0이 아니라면 즉, 남아있는 문자가 있다면 w+c에 해당하는 단어를 등록
        # if len(msg[tmp:]) > 0:            
        #     index_dict[word] = len(index_dict) + 1
    
        
    
    return answer
    