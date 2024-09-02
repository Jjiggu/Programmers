def solution(id_list, report, k):
    reported_count = {key:0 for key in id_list}
    reporter_count = {key:[] for key in id_list}
    restrict_list = []
    result = []
    
    for i in report:
        reporter, reported = i.split(" ")
        
        if reported not in reporter_count[reporter]:
            reporter_count[reporter].append(reported)
            reported_count[reported] += 1    
    
    for key, value in reported_count.items():
        if value >= k:
            restrict_list.append(key)
            
            
    for key, value in reporter_count.items():
        cnt = 0
        for i in value:
            if i in restrict_list:
                cnt += 1
        result.append(cnt)
    
    return result