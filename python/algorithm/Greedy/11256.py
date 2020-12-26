# 11256 사탕
# Greedy
import sys

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    box = []
    count = 0
    j, N = map(int, input().split())
    for i in range(N):
        r, c = map(int, input().split())
        box.append(r * c)
    box.sort(reverse=True)
    for b in box:
        if j > b:
            count += 1
            j -= b
        else:
            count += 1
            break
    print(count)

