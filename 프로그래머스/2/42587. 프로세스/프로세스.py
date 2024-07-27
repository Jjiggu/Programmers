from collections import deque

def solution(priorities, location):
    answer = 0
    result = []
    process_list = [i for i in range(len(priorities))]
    
    while priorities:
        now_pro = priorities.pop(0)
        if priorities:  # priorities가 비어 있지 않을 때만 max를 호출
            if now_pro >= max(priorities):
                x = process_list.pop(0)
                result.append(x)
                if x == location:
                    return len(result)
            else:
                priorities.append(now_pro)
                x = process_list.pop(0)
                process_list.append(x)
        else:
            # 이 부분은 priorities가 비어있는 경우입니다.
            # 만약 priorities가 비어 있다면 now_pro는 마지막 원소가 되어야 하므로 
            # max와 같은 비교를 하지 않고 단순히 마지막 원소를 처리합니다.
            x = process_list.pop(0)
            result.append(x)
            if x == location:
                return len(result)

    return result