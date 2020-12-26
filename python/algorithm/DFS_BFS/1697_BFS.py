# 1697 숨바꼭질
import sys
from collections import deque

input = sys.stdin.readline


def bfs(v):
    count = 0
    queue = deque([[v, count]])
    while queue:
        v = queue.popleft()
        pos = v[0]
        count = v[1]
        if not visited[pos]:
            visited[pos] = True
            if pos == K:
                return count
            count += 1
            if (pos * 2) <= 100000:
                queue.append([pos * 2, count])
            if (pos + 1) <= 100000:
                queue.append([pos + 1, count])
            if (pos - 1) >= 0:
                queue.append([pos - 1, count])
    return count


N, K = map(int, input().split())
visited = [False] * 100001
print(bfs(N))
