def solution(n, lost, reserve):
    # 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복 빌려줄 수 있음 -> 최대한 많은 학생이 체육수업을 들어야 함
    # 학생의 수 n, 체육복을 도난당한 학생들의 번호 lost, 여벌의 체육복을 가져온 학생 reserve
    # 여별 체육복이 있는 학생이 도난 가능
    result = 0
    # 정렬
    lost.sort()
    reserve.sort()
    
    # 체육복이 없는 학생 구하기
    non_reserve = [i for i in lost if i not in reserve]
    # 여별 체육복 있는 학생 
    reserve = [i for i in reserve if i not in lost]
    
    # 배열 돌면서(여벌 있는데 도난 당한 학생 제외) lost에게 빌려주기 
    for i in range(1, n + 1):
        if i not in non_reserve and i not in reserve:
            result += 1
        
    
    for student in reserve:
        if student - 1 in non_reserve:
            result += 2
            non_reserve.remove(student - 1)
            
        elif student + 1 in non_reserve:
            result += 2
            non_reserve.remove(student + 1)
            
        else:
            result += 1
    
    
    return result
    