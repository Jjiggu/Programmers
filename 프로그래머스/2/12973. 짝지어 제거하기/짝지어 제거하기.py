def solution(s):
    answer = -1

    s_stack = []
    tmp = ""
    
    # 반복문 돌면서 문자가 같으면 삭제 
    for index, letter in enumerate(s):
        s_stack.append(letter)
        if len(s_stack) >= 2:
            if s_stack[-1] == s_stack[-2]:
                s_stack.pop()
                s_stack.pop()
    
    if len(s_stack) == 0:
        return 1
    else:
        return 0
    
        # if letter == tmp:
        #     s.remove(s[index])
        #     s.remove(s[index - 1])
        #     tmp = letter
        # else:
        #     tmp = lette

