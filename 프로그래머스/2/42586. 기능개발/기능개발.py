def solution(progresses, speeds):
    # 작업 완료까지 걸리는 시간 계산
    done_time = []
    result = []
    
    for i in range(len(progresses)):
        done_num = (100 - progresses[i]) // speeds[i]
        if (100 - progresses[i]) % speeds[i] != 0:
            done_time.append(done_num + 1)
        else:
            done_time.append(done_num)
    
    # 처음부터 큰 수가 나올때까지 pop 
    max_num = done_time[0]
    cnt = 0
    
    for i in range(len(done_time)):
        if done_time[i] <= max_num:
            cnt += 1

        else:
            max_num = done_time[i]
            result.append(cnt)
            cnt = 1
        
        if i == len(done_time) - 1:
            result.append(cnt)
    
    return result