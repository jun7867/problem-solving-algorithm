# 2579 계단 오르기 - 실버3
# DP

import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())
score = [0]
d = [0] * 301
for i in range(N):
    score.append(int(input()))
if N > 0:
    d[1] = score[1]
if N > 1:
    d[2] = score[1] + score[2]
for i in range(3, N + 1):
    d[i] = max(score[i] + score[i - 1] + d[i - 3], score[i] + d[i - 2])
print(d[N])
