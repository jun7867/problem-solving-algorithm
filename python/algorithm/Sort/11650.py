# 11651 좌표 정렬하기2

import sys
input = sys.stdin.readline

N = int(input())
xy = []
for i in range(N):
    x, y = map(int, input().strip().split())
    xy.append((x, y))

xy.sort(key=lambda x: (x[1], x[0]))
for x, y in xy:
    print(x, y)

