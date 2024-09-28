def multi_union(list1, list2):
    list1_tmp = list1.copy()
    list1_result = list1.copy()
    
    for i in list2:
        if i not in list1_tmp:
            list1_result.append(i)
        else:
            list1_tmp.remove(i)
    
    return list1_result


def multi_intersection(list1, list2):
    result = []
    list1_copy = list1.copy()
    
    for i in list2:
        if i in list1_copy:
            list1_copy.remove(i)
            result.append(i)
        
    return result
   
    
def solution(str1, str2):
    answer = 0
    
    str1_list = [str1[i : i + 2].lower() for i in range(len(str1) - 1) if str1[i : i + 2].isalpha()]
    str2_list = [str2[j : j + 2].lower() for j in range(len(str2) - 1) if str2[j : j + 2].isalpha()]
    
    result_union = len(multi_union(str1_list, str2_list))
    result_intersection = len(multi_intersection(str1_list, str2_list))

    
    if result_intersection == 0 and result_union == 0:
        return 65536
    # elif result_intersection == 0 and result_union != 0:
    #     return 0
    else:
        answer = int((result_intersection / result_union) * 65536)
    
    return answer