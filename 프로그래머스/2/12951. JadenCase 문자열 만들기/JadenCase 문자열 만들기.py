def solution(s):
    answer = ''
    
    word_list = s.split(" ")
    result = []
    
    capitalized_words = [word.capitalize() for word in word_list]
    
#     for word in word_list:
#         if not word[0].isalpha():
#             result.append(word)
#         else:
#              result.append(word.capitalize())
    print(word_list)
    
    return " ".join(capitalized_words)