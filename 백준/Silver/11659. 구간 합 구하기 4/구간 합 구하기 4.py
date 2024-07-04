import sys
input = sys.stdin.readline

M, N = map(int, input().split())
num_list = list(map(int, input().split()))
prefix_sum = [0]

tmp = 0

for i in num_list:
    tmp += i
    prefix_sum.append(tmp)
    
for i in range(N):
    a, b = map(int, input().split())
    print(prefix_sum[b] - prefix_sum[a - 1])


