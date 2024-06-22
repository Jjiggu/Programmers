def solution(people, limit):
    answer = 0
    cnt = 0 # 구명보트 개수 초기화
    people = sorted(people) # 오름차순으로 정렬
    
    left = 0
    right = len(people) - 1
    
    # 배열에서 제일 작은값 2개 찾기
    while(left <= right):
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        cnt += 1
    
#     for i in range(len(people)):
#         if people[i] + people[right] <= limit: # 제일 큰 값과 작은 값 비교
#             right -= 1
#             result.append(people[i])
#             cnt += 1
        
#         elif people[i] + people[right] > limit: # 합이 limit 넘으면 제일 큰 값만 보트 가능
#             result.append(people[i])
#             cnt += 1
    
    
    return cnt