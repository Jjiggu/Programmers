def solution(id_list, report, k):
    # 신고 횟수 기록할 딕셔너리 생성
    # reported_count = {key:0 for key in id_list}
    reported_count = {key:[] for key in id_list}
    report_count = {key:[] for key in id_list}
    # 신고 누적 정리 리스트
    stop_list = []
    # 결과
    result = {key:0 for key in id_list}
    
    # 신고 기록
    for name in report:
        names = name.split()
        # reported_count[names[1]] += 1 # 신고 당한 횟수 -> 중복 신고 처리 필요(테케 2에 4 들어감)
        if names[0] not in reported_count[names[1]]:
            reported_count[names[1]] += [names[0]]
            
        if names[1] not in report_count[names[0]]: # 중복 신고 처리 
            report_count[names[0]] += [names[1]] # 신고한 명단
    
    # k번 이상 신고 당한 유저 찾기
    for key, value in reported_count.items():
        if len(value) >= k:
            stop_list.append(key)
    
    # 메일 처리 결과 받는 횟수 저장 
    for key, value in report_count.items():
        # report_count 와 stop_list 중복 개수 찾아 리턴
        for i in value:
            if i in stop_list:
                result[key] += 1
    
    return list(result.values())