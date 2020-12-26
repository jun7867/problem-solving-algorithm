# 1149 RGB 거리
# DP

import sys
input = sys.stdin.readline

n = int(input())
RGB = []
for i in range(n):
    RGB.append(list(map(int, input().strip().split())))

for i in range(1, n):
    #빨간집
    RGB[i][0] = min(RGB[i - 1][1], RGB[i - 1][2]) + RGB[i][0]
    #초록집
    RGB[i][1] = min(RGB[i - 1][0], RGB[i - 1][2]) + RGB[i][1]
    #파란집
    RGB[i][2] = min(RGB[i - 1][0], RGB[i - 1][1]) + RGB[i][2]
print(min(RGB[n - 1]))

