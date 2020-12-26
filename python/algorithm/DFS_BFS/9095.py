# 9095 1,2,3 더하기
# BackTracking
import sys

input = sys.stdin.readline


def bt(value, sum):
    global count
    if sum >= n:
        return
    sum += value
    if sum == n:
        count += 1
    bt(1, sum)
    bt(2, sum)
    bt(3, sum)


T = int(input())
for i in range(T):
    n = int(input())
    count = 0
    bt(0, 0)
    print(count)
