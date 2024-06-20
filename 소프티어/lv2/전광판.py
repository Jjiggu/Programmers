"""[21년 재직자 대회 예선] 전광판
난이도 Lv. 2
정답률 71.37 %
https://softeer.ai/practice/6268"""

import sys

# 숫자 별 전구 점등 상태(1 : 켜짐, 0 : 꺼짐)
num_dic = {"0": "1110111",
           "1": "0010010",
           "2": "1011101",
           "3": "1011011",
           "4": "0111010",
           "5": "1101011",
           "6": "1101111",
           "7": "1110010",
           "8": "1111111",
           "9": "1111011",
           " ": "0000000"}

T_num = int(input())

for i in range(T_num):
    num_from, num_to = input().split()

    # 다섯자리로 설정
    num_from = num_from.rjust(5, " ")
    num_to = num_to.rjust(5, " ")
    # num_from = (5 - len(num_from)) * " " + num_from
    # num_to = (5 - len(num_to)) * " " + num_to

    total_sum = 0

    # # 스위치 눌러야 하는 횟수
    for f_num, t_num in zip(num_from, num_to):
        for j in range(7):  # 비트 자릿수
            total_sum += (num_dic[f_num][j] != num_dic[t_num][j])  # 숫자가 같지 않으면 +1

    # 스위치 눌러야 하는 횟수
    # for k in range(5):
    #     # for i in range(5): # 숫자 자릿수
    #     for j in range(7): # 비트 자릿수
    #         # 숫자가 같이 않으면 +1
    #         total_sum += (num_dic[num_from[k]][j] != num_dic[num_to[k]][j])

    print(total_sum)



