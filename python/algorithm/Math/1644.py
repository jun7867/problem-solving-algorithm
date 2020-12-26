# 1644 소수의 연속합
# Math 소수
# 투 포인터
import sys

input = sys.stdin.readline
N = int(input())
primeList = []
array = [False, False] + [True] * (N - 1)

for i in range(2, N + 1):
    if array[i]:
        primeList.append(i)
    for j in range(i * i, N + 1, i):
        array[j] = False

interval_sum = 0
end = 0
count = 0
start = 0
while True:
    if interval_sum >= N:
        if interval_sum == N:
            count += 1
        interval_sum -= primeList[start]
        start += 1
    elif end == len(primeList):
        break
    else:
        interval_sum += primeList[end]
        end += 1
print(count)

