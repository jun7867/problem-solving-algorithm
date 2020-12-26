# 1932 정수 삼각형
# DP

import sys
input = sys.stdin.readline

n = int(input())
tri = []
for i in range(n):
    tri.append(list(map(int, input().strip().split())))

#왼쪽 대각선 더하기 , 오른쪽 대각선 더하기
for i in range(1, n):
    for j in range(len(tri[i])):
        if j == 0:
            tri[i][j] = tri[i][j] + tri[i - 1][j]
        elif j == len(tri[i]) - 1:
            tri[i][j] = tri[i][j] + tri[i - 1][j - 1]
        else:
            tri[i][j] = max(tri[i][j] + tri[i - 1][j],
                            tri[i][j] + tri[i - 1][j - 1])

print(max(tri[n - 1]))

