def solution(n, lost, reserve):
    # 정렬
    lost.sort()
    reserve.sort()
	
    # lost, reserve에 공통으로 있는 요소 제거
    for i in reserve[:]:
        if i in lost:
            reserve.remove(i)
            lost.remove(i)
	
    # 체육복 빌려주기(나의 앞 번호부터 확인)
    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)
    
    return n-len(lost)
#     cnt = len(reserve)
    
#     # 길이 n만큼 True로 초기화 한 배열 생성
#     student = [True for i in range(n)]
#     # 체육복 도둑맞은 학생 false로 초기화
#     for lo in lost:
#         student[lo - 1] = False
    
#     # 여벌 체육복 가져온 학생 중 체육복 도둑맞은 학생 
#     for i in range(len(reserve)):
#         for j in range(len(lost)):
#             if reserve[i] == lost[j]:
#                 cnt += 1
#                 # student[reserve(i)] = True
#                 reserve[i] = -1
    
#     for i in range(len(reserve)):
#         for j in range(len(lost)):
#             if reserve[i] == (lost[j] - 1) or reserve[i] == (lost[j] + 1):
#                 if reserve[i] != -1:
#                     cnt += 1
#                     reserve[i] = -1
#                 else:
#                     continue
            
#     print(reserve)
    
#     return cnt