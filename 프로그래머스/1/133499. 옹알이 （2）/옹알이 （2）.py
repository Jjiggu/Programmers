def solution(babbling):
    result = 0
    possible_list = ["aya", "ye", "woo", "ma"]
    word_double = ""
    
    for i in range(len(babbling)):
        for possible in possible_list:
            if possible * 2 not in babbling[i]:
                # if word_double == possible:
                #     word_double = ""
                #     break
                # else:
                #     word_double = possible
                babbling[i] = babbling[i].replace(possible, "*")
    
        if all(char == "*" for char in babbling[i]):
            result += 1

    
    print(babbling)
    return result