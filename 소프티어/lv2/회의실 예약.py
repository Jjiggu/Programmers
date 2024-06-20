"""
[21년 재직자 대회 예선] 회의실 예약
난이도 Lv. 2
정답률 64.80 %
https://softeer.ai/practice/6266
"""

import sys

room_cnt, room_booked_cnt = map(int, input().split())

room_list = {}

tmp = room_cnt

for _ in range(room_cnt):  # 회의실 이름 및 시간 초기화
    x = input()
    room_list[x] = [0] * 10

for _ in range(room_booked_cnt):  # 회의실 예약 시간 초기화
    room_name, start_t, end_t = input().split()
    # 예약 시간 1로 초기화
    for i in range((int(start_t) - 9), (int(end_t) - 9)):
        (room_list[room_name])[i] = 1  # 예약 시간 1로 초기화

# 오름차순으로 정렬
room_list = dict(sorted(room_list.items()))

# 회의실 사용 가능 여부 확인
for key, value in room_list.items():
    availd_t = []

    current = 1

    for index, k in enumerate(value):  # 가능한 시간대 출력
        if k == 0 and current == 1:  # 처음 나온 0
            if index == 0:
                start = index
            else:
                # start = index - 1
                start = index
            current = 0


        elif k == 1 and current == 0:
            end = index
            availd_t.append([start + 9, end + 9])
            current = 1

        # k = 0 으로 끝날 경우 end 포인트 찍어주는 로직이 필요

        elif k == 0 and current == 0 and index == len(value) - 1:
            end = index
            availd_t.append([start + 9, end + 9])
            current = 0

    if len(availd_t) > 0:  # 출력
        print(f"Room {key}:")
        print(f"{len(availd_t)} available:")
        for i in availd_t:
            if (i[0] == 9):
                print(f"09-{i[1]}")
            else:
                print(f"{i[0]}-{i[1]}")
        if tmp > 1:
            print("-----")
            tmp -= 1

    else:
        print(f"Room {key}:")
        print("Not available")
        if tmp > 1:
            print("-----")
            tmp -= 1

# 엣지 로케이션
# tp:
# 1 2
# avante
# avante 9 11
# avante 12 13

# 답:
# Room avante:
# 2 available:
# 11-12
# 13-18
