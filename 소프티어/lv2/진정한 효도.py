"""
진정한 효도
https://softeer.ai/practice/7374

난이도
Lv. 2

정답률
52.73 %
"""

import sys
from collections import Counter

ground = [list(map(int, input().split())) for _ in range(3)]  # 땅 높이 초기화
reverse_ground = [list(x) for x in zip(*ground)]  # 전치
cost = 0  # 땅 비용
min_cost = 1000  # 최소 비용

# 농사 지을 수 있는 땅 -> 1*3 or 3*1
for i in range(3):
    # 행
    if len(Counter(ground[i])) == 1:
        cost = 0
        if cost < min_cost:
            min_cost = cost

    elif len(Counter(ground[i])) == 3:
        if cost < min_cost:
            min_cost = 2

    else:
        cost = max(ground[i]) - min(ground[i])

        if cost < min_cost:
            min_cost = cost

# 농사 지을 수 있는 땅 -> 1*3 or 3*1
for i in range(3):
    # 행
    if len(Counter(reverse_ground[i])) == 1:
        cost = 0
        if cost < min_cost:
            min_cost = cost

    elif len(Counter(reverse_ground[i])) == 3:
        if cost < min_cost:
            min_cost = 2

    else:
        cost = max(reverse_ground[i]) - min(reverse_ground[i])

        if cost < min_cost:
            min_cost = cost

print(min_cost)
