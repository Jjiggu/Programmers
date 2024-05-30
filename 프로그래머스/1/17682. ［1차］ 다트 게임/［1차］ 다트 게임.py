def solution(dartResult):
#     answer = 0
#     bonus = {"S" : 1,
#             "D" : 2,
#             "T" : 3}
#     option = {"*" : 2,
#              "#" : -1}
    
#     result = 0
#     result_answer = 0
    
    
#     # 점수는 각각 S : **1, D : **2, T : **
#     # *는 점수 2배 -> 중첩 가능 : 4배
#     # *와 #이 중첩되면 *-2
    
    
#     for i in dartResult:
#         if i.isdigit():
#             print(f"숫자{i}")
            
#             # 점수 저장
#             result += int(i)
            
#             answer += int(i)
            
#             print(f"숫자 결과는 {result}")
            
#         elif i.isalpha():
#             print(f"보너스{i}")
#             result ** int(bonus[i])
#             answer ** int(bonus[i])
    
#             print(f"보너스 숫자는 {int(bonus[i])}")
#             print(f"보너스 결과는 {result}")
            
#         else:
#             print(f"옵션{i}")
#             answer *= int(option[f"{i}"])
#             print(f"옵션 결과는 {result}")
        
#         result_answer += result
    
#     return result_answer
    squares = {
        "S": 1,
        "D": 2,
        "T": 3,
    }
    scores = []
    temp = ""
    for char in dartResult:
        if char.isdigit():
            temp += char  # 문자가 숫자일 때 더해서 임시 저장
        elif char.isalpha():
            # 문자가 S, D, T 일때 임시 저장한 변수를 정수화 해서 제곱하고 삽입
            scores.append(pow(int(temp), squares[char]))
            temp = ""  # 임시 저장 변수 초기화
        elif char == "*":
            if len(scores) > 1:  # 현재 점수와 바로 이전 점수에 스타상 적용
                scores[-2] *= 2
            scores[-1] *= 2
        elif char == "#":  # 현재 점수에 아차상 적용
            scores[-1] *= -1

    # 모두 더한 점수를 출력
    answer = sum(scores)
    return answer