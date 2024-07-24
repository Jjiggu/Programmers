def solution(citations):
    answer = 0
    
    h_list = []
    h_index = 0
    
    citations = sorted(citations)
    
    for i in range(len(citations)):
        cnt = 0
        for j in citations:
            if j >= citations[i]:
                cnt += 1
                
        h_index = min(cnt, citations[i])
        h_list.append(h_index)
            
    
    return max(h_list)