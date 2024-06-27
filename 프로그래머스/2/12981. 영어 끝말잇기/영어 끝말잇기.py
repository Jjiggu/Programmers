def solution(n, words):
    word_list = [] # 사용된 단어를 저장하는 리스트
    
    words_set = set() # 사용된 단어를 저장하는 set() / 중복 방지
    words_set.add(words[0]) # 첫번째 단어를 저장
    
    for i in range(1, len(words)): # 두 번째 단어에서 마지막 단어까지 순회
        # 만약 현재 단어가 이미 사용된 단어이거나
        # 이전 단어의 마지막 글자와 현재 단어의 첫 번째 글자가 다르다면
        if(words[i] in words_set) or (words[i-1][-1] != words[i][0]):
            # 탈락자 번호와 차례를 반환
            return([(i % n) + 1, (i//n) + 1])
        words_set.add(words[i])
        
    return [0, 0]
    
#     # 탈락자가 생기는 경우
#     for index, word in enumerate(words):    
#         if index == len(words) - 1: # 마지막 단어인 경우
#             word_list.append(word)
            
#         else:
#             if word[-1] == words[index + 1][0]: # 끝말잇기가 잘 진행되는 경우
#                 word_list.append(word)
#             elif word[-1] != words[index + 1][0]: # 다른 단어를 말 한 경우
#                 word_list.append(word)
#                 word_list.append(words[index + 1]) # 다른 단어 포함
#                 return [n - len(word_list) % n, len(word_list) - len(word_list) // n]
    
#     # print(word_list)
#     if word_list[-1] in word_list[:-1]: # 이미 나온 단어 말하는 경우
#         # 몫이 0이 아닌 경우 -> 순서 +1 해줘야 됨
#         num_f = n - len(word_list) % n
        
#         if len(word_list) % n > 0:
#             my_turn = len(word_list) // n + 1
#         else:
#             my_turn = len(word_list) // n
#         return [num_f, my_turn]
    
#     elif len(word_list) == len(words):
#         return [0, 0] # 잘 끝난 경우