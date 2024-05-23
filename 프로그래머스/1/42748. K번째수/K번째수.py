def solution(array, commands):
    answer = []
    result = []
    
    # 배열 하나씩 뽑음
    for array_list in commands:
        sorted_list = sorted(array[array_list[0] - 1 : array_list[1]])
        result.append(sorted_list[array_list[2] - 1])
    return result