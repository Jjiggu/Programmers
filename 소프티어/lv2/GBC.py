"""
GBC
https://softeer.ai/practice/6270

난이도
Lv. 2
제출

정답률
41.95 %
"""

import sys

x, y = map(int, input().split())

limit = [0] * 100
now = 0
result = 0

for _ in range(x):
    section, speed = map(int, input().split())

    for num in range(now, now + section):
        limit[num] = speed

    now += section

now = 0

for _ in range(y):
    section, speed = map(int, input().split())

    for i in range(now, now + section):
        result = max(result, speed - limit[i])

    now = now + section

print(result)

# limit_speed = [list(map(int, input().split())) for _ in range(x)]
# gw_speed = [list(map(int, input().split())) for _ in range(y)]

# limit_sum = 0
# gw_sum = 0
# max_speed = []

# # 광수 목록 순회하면서 층수 범위 확인
# # 속하는 범위에 해당하는 최댓값 저장
# for i in range(len(gw_speed)):
#     limit_sum += limit_speed[i][0]
#     gw_sum += gw_speed[i][0]

#     if gw_sum <= limit_sum: # 구간에 속하는 경우
#         if gw_speed[i][1] > limit_speed[i][1]: # 제한속도 초과한 경우
#             max_speed.append(abs(gw_speed[i][1] - limit_speed[i][1]))

#         else: # 제한속도 초과하지 않은 경우
#             max_speed.append(0)

#     elif gw_sum > limit_sum:
#         if gw_speed[i][1] > limit_speed[i][1]: # 제한속도 초과한 경우
#             if i == (len(gw_speed) - 1):
#                 max_speed.append(abs(gw_speed[i][1] - limit_speed[i][1]))

#             else:
#                 max_speed.append(abs(gw_speed[i][1] - limit_speed[i][1]))
#                 max_speed.append(abs(gw_speed[i][1] - limit_speed[i + 1][1]))

#         else: # 제한속도 초과하지 않은 경우
#             max_speed.append(0)

# print(max(max_speed))
