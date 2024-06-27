"""
[21년 재직자 대회 예선] 비밀 메뉴
https://softeer.ai/practice/6269

난이도
Lv. 2

정답률
54.44 %
"""
import sys

m, n, k = map(int, input().split()) # m = 비밀 메뉴 조작 번호 개수, n = 사용자의 버튼 조작 개수, k = 정수 범위

secret_menu = input().split()
user_input = input().split()


for i in range(m, n + 1): # user_input 배열을 len(secret_menu)만큼 잘라서 순회 -> 길이가 1 차이 나는 경우도 있어 n 값에 +1 해줘야 됨
    if len(secret_menu) > len(user_input): # 길이가 짧은 경우
        print("normal")
    else:
        if user_input[i - m : i] == secret_menu: # secre_menu와 같은 문자열이 반환되면 return secret
            print("secret")
            break
else: # 순회후에도 같은 문자열 없으면 return normal
    print("normal")


