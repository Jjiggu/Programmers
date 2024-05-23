def solution(n, arr1, arr2):
    answer = []
    arr1_list = []
    arr2_list = []
    result = []
    # 진수 변환 후 저장
    for ar1, ar2 in zip(arr1, arr2):
        arr1_binaryNum = format(ar1, 'b')
        arr2_binaryNum = format(ar2, 'b')
        
        # 2진수끼리 AND 연산
        and_result = format(int(arr1_binaryNum, 2) | int(arr2_binaryNum, 2), 'b')
        
        # 2개 겹친 배열에서 1이면 #, 0이면 " "
        # result.append(and_result.zfill(n).replace("1", "#").replace("0", " "))
        result.append(and_result.rjust(n, '0').replace("1", "#").replace("0", " "))
        
    
    return result