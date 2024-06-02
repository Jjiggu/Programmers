def solution(participant, completion):
    result = {}
    
    for person in participant:
        if person in result:
            result[person] += 1
        else:
            result[person] = 1
    
    for people in completion:
        if people in result:
            result[people] -= 1
        
    for i in result:
        if result[i] == 1:
            return i
    

# 효율성 테스트 통과 못 한 코드 -> remove가 O(n)의 시간복잡도를 가짐
#     for index, element in enumerate(completion):
#         participant.remove(element)

#     return participant[0]

    
    