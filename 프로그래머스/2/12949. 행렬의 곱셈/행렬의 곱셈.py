import numpy as np

def solution(arr1, arr2):
    arr1 = np.array(arr1)
    arr2 = np.array(arr2)
    result = []
    
    answer = np.dot(arr1, arr2)
    
    return answer.tolist()