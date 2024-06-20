def solution(s):    
    bracket_stack = []
    
    for i in s:
        if i == "(":
            bracket_stack.append(i)
        
        elif i == ")":
            if len(bracket_stack) != 0:
                bracket_stack.pop()
            else:
                bracket_stack.append(i)
                
    if len(bracket_stack) == 0:
        return True
    
    else: 
        return False