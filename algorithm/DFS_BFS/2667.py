# 2667 단지번호붙이기
import sys
from collections import deque

input = sys.stdin.readline


def dfs(x, y):
    global count
    if x <= -1 or x >= N or y <= -1 or y >= N:
        return False
    if graph[x][y] == 1:
        count += 1
        graph[x][y] = 0
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input().strip())))

result = 0
danji = []
count = 0
for i in range(N):
    for j in range(N):
        if dfs(i, j) == True:
            result += 1
            danji.append(count)
            count = 0
print(result)
danji.sort()
for d in danji:
    print(d)
