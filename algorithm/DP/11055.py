# 11055
# 가장 큰 증가 부분 수열 LIS

import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
dp = [x for x in A]

for i in range(n):
    for j in range(i):
        if A[i] > A[j]:
            dp[i] = max(dp[i], dp[j] + A[i])
print(max(dp))
