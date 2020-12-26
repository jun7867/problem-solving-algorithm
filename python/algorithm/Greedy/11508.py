# 11508 2+1
# Greedy
import sys

input = sys.stdin.readline

N = int(input())
c = []
for i in range(N):
    c.append(int(input()))
c.sort(reverse=True)
total = 0
q = N // 3
for i in range(q):
    total += c[i * 3] + c[i * 3 + 1]
for j in range(N - q * 3):
    total += c[-(j + 1)]

print(total)
