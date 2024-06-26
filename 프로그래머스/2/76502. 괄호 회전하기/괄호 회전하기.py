def left_rotate(rotate_list, n):
    return rotate_list[n:] + rotate_list[:n] 

def solution(s):
    answer = -1
    correct_cnt = 0
    bracket_dic = {")" : "(", "}" : "{", "]" : "["}
    
    # s를 len(s) 만큼 회전
    for i in range(0, len(s)):
        # s = left_rotate(s, i)   
        rotate_s = s[i:] + s[:i]
        bracket_list = []
        
        for char in rotate_s: # 올바른 괄호 판별
            if char in ("({["):
                bracket_list.append(char)
                
            else: 
                if bracket_list: # 스택에 남아있는 괄호가 있다면
                    top = bracket_list.pop() # 스택 top의 열린 괄호
                    
                    if (bracket_dic[char] != top): # 해당 닫힌 괄호와 스택 top의 열린 괄호가 짝이 맞지 않는다면
                        answer = 0
                        continue
                    
                else: # 스택이 비어있다면
                    answer = 0
                    break
        
            answer = 1 # 괄호 짝이 맞다면 answer = 1로 초기화
            
        if answer == 1 and len(bracket_list) == 0: # 올바른 괄호라면 cnt + 1
            correct_cnt += 1
    
    return correct_cnt