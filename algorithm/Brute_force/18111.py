import sys
n, m, b = map(int, sys.stdin.readline().split())
ground = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
height = 0
ans = 1000000000000000000000000000000

for i in range(257):
    down = 0
    up = 0
    for j in range(n):
        for k in range(m):
            if ground[j][k] < i:
                up += (i - ground[j][k])
            else:
                down += (ground[j][k] - i)
    inventory = down + b
    if inventory < up:
        continue
    time = 2 * down + up
    if time <= ans:
        ans = time
        height = i
print(ans, height)
