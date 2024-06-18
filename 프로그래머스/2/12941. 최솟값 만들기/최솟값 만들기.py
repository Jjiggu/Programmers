def solution(A,B):
    result = 0
    
    A = sorted(A)
    B = sorted(B, reverse=True)
    
    # 최소가 되려면 가장 큰 수와 가장 작은수의 곱
    for i in range(len(A)):
        result += (A[i] * B[i])
        
        # 시간초과
#         max_num = min(A)       
#         min_num = max(B)
        
#         result += (max_num * min_num)
        
#         A.remove(max_num)
#         B.remove(min_num)
    
    return result