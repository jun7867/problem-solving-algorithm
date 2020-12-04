# 프로그래머스 DFS / BFS
# 네트워크 bfs

n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]

visited = [0 for _ in range(n)]
queue = []
count = 0
while 0 in visited:
    x = visited.index(0)
    queue.append(x)
    visited[x] = 1
    while queue:
        index = queue.pop(0)
        visited[index] = 1
        for i in range(n):
            if computers[index][i] == 1 and visited[i] == 0:
                queue.append(i)
                visited[i] = 1
    count += 1
print(count)
