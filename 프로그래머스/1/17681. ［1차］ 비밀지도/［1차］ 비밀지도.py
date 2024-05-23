def solution(n, arr1, arr2):
    answer = []
    arr1_list = []
    arr2_list = []
    result = []
    # 진수 변환 후 저장
    for ar1, ar2 in zip(arr1, arr2):
        arr1_binaryNum = format(ar1, 'b')
        arr1_list.append(format(ar1, 'b').zfill(n))
        
        arr2_binaryNum = format(ar2, 'b')
        arr2_list.append(format(ar2, 'b').zfill(n))
        
        # 2진수끼리 AND 연산
        
        and_result = format(int(arr1_binaryNum, 2) | int(arr2_binaryNum, 2), 'b')
        result.append(and_result.zfill(n))
    
    # 2개 겹친 배열에서 1이면 #, 0이면 " "
    for binary in result:
        wall = binary.replace("1", "#").replace("0", " ")
        answer.append(wall)
        
    
    return answer