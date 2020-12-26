# 2304
# 창고 다각형

import sys
input = sys.stdin.readline

maxH = 1
maxL = 0
n = int(input())
pillar = []
#  가장 큰 높이값, 그 높이값의 index, 가장 긴 L 찾기
for i in range(n):
    L, H = map(int, input().strip().split())
    pillar.append([L, H])
    if maxL < L:
        maxL = L
    if maxH < H:
        maxH = H
        maxIndex = L


pillarList = [0] * (maxL + 1)
for l, h in pillar:
    pillarList[l] = h

total = 0
temp = 0
for i in range(maxIndex + 1):
    if pillarList[i] > temp:
        temp = pillarList[i]
    total += temp
temp = 0
for i in range(maxL, maxIndex, -1):
    if pillarList[i] > temp:
        temp = pillarList[i]
    total += temp
print(total)
