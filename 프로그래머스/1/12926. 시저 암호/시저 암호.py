def solution(s, n):
    s = list(s)
    
    for i in range(len(s)):
        if s[i].isupper():
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
            
        elif s[i].islower():
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
            
        # if i == ' ':
        #     answer += i
        # else:
        #     word = ord(i)
        #     answer += chr(word + n)
    
    return "".join(s)