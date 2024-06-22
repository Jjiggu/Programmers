"""
지도 자동 구축
https://softeer.ai/practice/6280
난이도
Lv. 2
정답률
60.93 %
"""


import sys

n = int(input())
result = 0

# 2로 시작하는 등비 2인 등비수열
result = 1 + 2**(n)

print(result * result)