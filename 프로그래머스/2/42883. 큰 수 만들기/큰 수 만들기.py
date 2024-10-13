def solution(number, k):
    max_len = len(number) - k
    result = 0
    stack = []
    
    for i in number:
        while len(stack) > 0 and k > 0 and stack[-1] < i:
            stack.pop()
            k -= 1
        stack.append(i)
                
    
    return "".join(stack[:max_len])
    