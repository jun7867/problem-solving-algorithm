# 1929 소수 구하기
# math
# 에라토스테네스의 체
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

array = [True] * (M + 1)
array[0] = False
array[1] = False

for i in range(2, M + 1):
    if array[i]:
        if i >= N:
            print(i)
    # 배수 다 지우기
    for j in range(2 * i, M + 1, i):
        array[j] = False
