def solution(s):
    word_list = list(s.split(" "))
    upper_word = ""
    
    for i in range(len(word_list)):
        j = 0
        for letter in word_list[i]:
            if j % 2 == 0:
                upper_word += letter.upper()
                j += 1
            else:
                upper_word += letter.lower()
                j += 1
        upper_word += " "

    return(upper_word[0:-1])
