def solution(N, stages):
    # 실패율 = 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    # N = 전체 스테이지 수, N + 1은 N번째 스테이지까지 클리어 한 사용자
    # stages = 사용자가 멈춰있는 스테이지의 번호
    # 클리어 하지 못한 플레이어의 수 = 스테이지 번호보다 작거나 같은 수를 가진 플레이어
    # 스테이지에 도달 한 플레이어의 수 = 스테이지 번호보다 큰 수를 가진 플레이어

    result = []
    stage_dic = {}
    
    # 1 ~ N : i 까지 반복문 돌면서 실패율 계산
    for stage in range(1, N + 1):     
        # 다음 스테이지 넘어갈 경우 실패율 초기화
        not_clear = 0
        reach_stage = 0
        for i in stages:
            # stages[n]이 i보다 작거나 같으면 클리어하지 못한 플레이어 not_clear += 1
            # 2스테이지에 올라온 경우 not_clear는 1스테이지 플레이어를 포함하면 안 됨
            # if stage - 1 < i <= stage:
            if i == stage:
                not_clear += 1
            # stages[n]이 i보다 크거나 같으면 스테이지에 도달한 플레이어 reach_stage += 1
            if i >= stage:
                reach_stage += 1

        # fail_percentage에 인덱스와 append not_clear / reach_stage 저장
        # 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
        if reach_stage == 0:
            stage_dic[stage] = 0
        else:
            stage_dic[stage] = not_clear/reach_stage

    # 실패율 내림차순 정렬(같은 경우 오름차순) -> 인덱스 번호(스테이지 번호) 출력
    result = sorted(stage_dic.items(), key=lambda x: x[1], reverse=True)
    
    return list(floor[0] for floor in result)