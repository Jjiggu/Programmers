def solution(ingredient):    
    result = 0
    current_stack = []
    
    for i in ingredient:
        current_stack.append(i)
        if current_stack[-4:]==[1, 2, 3, 1]:
            del current_stack[-4:]
            result += 1
    return result
