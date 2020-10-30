# 1182 부분수열의 합
# BackTracking
import sys

input = sys.stdin.readline


def dfs(index, sum):
    global count
    if index >= N:
        return
    sum += N_list[index]
    if sum == S:
        count += 1
    dfs(index + 1, sum - N_list[index])
    dfs(index + 1, sum)


N, S = map(int, input().split())
N_list = list(map(int, input().split()))

visit = [False] * N
count = 0
dfs(0, 0)
print(count)

