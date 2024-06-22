"""
8단 변속기
https://softeer.ai/practice/6283

난이도
Lv. 2
정답률
60.06 %
"""

import sys

change_list = list(input().split())

acc = ["1", "2", "3", "4", "5", "6", "7", "8"]
des = ["8", "7", "6", "5", "4", "3", "2", "1"]

if change_list == acc:
    print("ascending")
elif change_list == des:
    print("descending")
else:
    print("mixed")

