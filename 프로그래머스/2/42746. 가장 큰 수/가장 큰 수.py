from functools import cmp_to_key
        
def solution(numbers):

    def compare(x, y):
        # x와 y를 문자열로 변환한 후 두 가지 순서로 비교하여 큰 순서대로 정렬
        if x + y > y + x:
            return -1
        elif x + y < y + x:
            return 1
        else:
            return 0
        
    nums_str = list(map(str, numbers))
    nums_str.sort(key=cmp_to_key(compare))
    
    # 리스트가 모두 '0'으로만 이루어진 경우를 처리하기 위해 int로 변환 후 다시 문자열로 변환
    largest_num = ''.join(nums_str)
    
    # 결과 반환
    return largest_num.lstrip('0') or '0'
