import numpy as np

def solution(numbers, hand):
    answer = ''
    
    phone_num = {1:[0, 0],
                 2:[0, 1],
                 3:[0, 2],
                 4:[1, 0],
                 5:[1, 1],
                 6:[1, 2],
                 7:[2, 0],
                 8:[2, 1],
                 9:[2, 2],
                 "*":[3, 0],
                 0:[3, 1],
                 "#":[3, 2] }
    
    left_location = phone_num["*"]
    right_location = phone_num["#"]
    
    # 이동 좌표 오른쪽 [0, +1], 왼쪽 [0, -1], 위 [+1, 0], 아래 [-1, 0]
    for num in numbers:
        if num in (1, 4, 7):
            answer += "L"
            left_location = phone_num[num]
            print("왼쪽 번호에 있음 L")
            
        elif num in (3, 6, 9):
            answer += "R"
            right_location = phone_num[num]
            print("오른쪽 번호에 있음 R")
            
        elif num in (2, 5, 8, 0):
            # 거리 비교
            left_distance = sum(abs((np.array(phone_num[num]) - np.array(left_location))))
            right_distance = sum(abs((np.array(phone_num[num]) - np.array(right_location))))
            print(f"왼쪽 거리 : {left_distance}")
            print(f"오른쪽 거리 : {right_distance}")
            # 거리가 짧은 손가락으로 위치 초기화
            if left_distance < right_distance:
                left_location = phone_num[num]
                answer += "L"
                print("L")
                
            elif left_distance > right_distance:
                right_location = phone_num[num]
                answer += "R"
                print("R")
            # 거리가 같은 경우
            elif left_distance == right_distance: 
                if hand == "right":
                    answer += "R"
                    right_location = phone_num[num]
                    print("같은 경우 R")
                elif hand == "left":
                    answer += "L"
                    left_location = phone_num[num]
                    print("같은 경우 L")
                
            
    
    return answer