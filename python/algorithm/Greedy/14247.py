# 14247 나무 자르기
# Greedy
import sys

input = sys.stdin.readline
n = int(input())
tree = []
speed = []
array = []
tree = list(map(int, input().split()))
speed = list(map(int, input().split()))
for i in range(n):
    array.append([tree[i], speed[i]])

array.sort(key=lambda x: x[1])
total = 0
for i in range(n):
    total += array[i][0] + array[i][1] * i
print(total)
