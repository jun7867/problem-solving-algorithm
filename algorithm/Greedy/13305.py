# 13305 주유소
# Greedy
import sys

input = sys.stdin.readline
N = int(input())
road = []
price = []
road = list(map(int, input().split()))
price = list(map(int, input().split()))
total = 0
minV = sys.maxsize

for i in range(N - 1):
    if i == 0:
        total += price[0] * road[0]
        minV = min(minV, price[i])
    else:
        minV = min(minV, price[i])
        total += minV * road[i]
print(total)

