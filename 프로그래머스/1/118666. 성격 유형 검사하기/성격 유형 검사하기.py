def solution(survey, choices):
    answer = ''
    
    # 지표별 점수 
    score = {"R":0, 
             "T":0,
             "C":0,
             "F":0,
             "J":0,
             "M":0,
             "A":0,
             "N":0            
            }
    
    # survey 돌면서 점수 최신화
    for index, types in enumerate(survey):
        # 4보다 작으면 왼쪽 유형에 점수
        if choices[index] < 4:
            score[types[0]] += 4 - choices[index]
        
        # 4보다 크면 오른쪽 유형에 점수
        elif choices[index] > 4:
            score[types[1]] += choices[index] - 4
            
        elif choices[index] == 4:
            continue
    
    # 유형 확인
    answer += 'R' if score['R'] >= score['T'] else 'T'
    answer += 'C' if score['C'] >= score['F'] else 'F'
    answer += 'J' if score['J'] >= score['M'] else 'M'
    answer += 'A' if score['A'] >= score['N'] else 'N'
    
    return answer