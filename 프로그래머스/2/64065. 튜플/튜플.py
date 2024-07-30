def solution(s):
    answer = set()
    result = []
    list_s = ""
    
    for i in s:
        if i == "{":
            list_s += "["
        if i == "}":
            list_s += "]"
        if i not in ("{", "}"):
            list_s += i
    
    # 각 집합을 길이 순서대로 정렬
    list_s = sorted(eval(list_s), key = len)
    
    for i in list_s:
        # 새로운 리스트를 생성하여 중복 제거
        diff = [x for x in i if x not in result]
        result.extend(diff)
        
    # # set사용해서 중복 제거하면 답
    # for i in list_s:
    #     # result.append(list(set(i) - set(result)))
    #     result.append(list(set(i) - set(result)))

    
    return result