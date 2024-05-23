from itertools import combinations
def solution(nums):
    answer = 0
    cnt = 0
    prime_list = []
    
    for i in combinations(nums, 3):
        prime_number = sum(i)
        for i in range(1, prime_number + 1):
            if prime_number % i == 0:
                cnt += 1
        if cnt == 2:
            answer += 1
        # prime_list.append(cnt)
        cnt = 0
            
        

    return answer