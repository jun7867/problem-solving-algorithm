# 2606 바이러스
import sys
from collections import deque

input = sys.stdin.readline


def bfs(graph, start, visited):
    count = 0
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                count += 1
    return count


N = int(input())
th = int(input())
graph = [[] for _ in range(N + 1)]
for i in range(th):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(N + 1):
    graph[i].sort()
visited = [False] * (N + 1)

print(bfs(graph, 1, visited))

