#2565 전깃줄
#LIS

import sys
input = sys.stdin.readline

n = int(input())
wire = {}

for i in range(n):
    a, b = map(int, input().split())
    wire[a] = b
wire = sorted(wire.items())
arr = []
for key, value in wire:
    arr.append(value)

DP = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            DP[i] = max(DP[i], DP[j] + 1)
result = n - max(DP)
print(result)
# O(n ^ 2)

