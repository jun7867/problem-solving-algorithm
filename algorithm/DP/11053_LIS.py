#11053 가장 긴 증가하는 부분 수열
#LIS

import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().strip().split()))
DP = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            DP[i] = max(DP[i], DP[j] + 1)
print(max(DP))
#O(n^2)

