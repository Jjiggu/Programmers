def solution(s):
    word_list = list(s.split(" "))
    result = []
    upper_word = ""
    j = 0
    
    for i in range(len(word_list)):
        for letter in word_list[i]:
            if j % 2 == 0:
                upper_word += letter.upper()
                j += 1
            else:
                upper_word += letter.lower()
                j += 1
        upper_word += " "
        result.append(upper_word)
        j = 0
    
#     for i in range(len(answer)):
#         if answer[i] == ' ':
#             result.append(answer[i])
        
#         elif i % 2 == 0:
#             result.append(answer[i].upper())
            
#         else:
#             result.append(answer[i])
    result = result[-1]
    return result[0:-1]
