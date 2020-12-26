# 1026 보물

import sys
input = sys.stdin.readline

N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A_sort = sorted(A)
B_reverse = sorted(B, reverse=True)

result = 0
for i in range(N):
    result += A_sort[i] * B_reverse[i]
print(result)
