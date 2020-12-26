# 1978 소수 찾기
# math

# 소수 2, 3, 5 ,7 ,11 ,13 ....
import sys

input = sys.stdin.readline

N = int(input())
Nlist = []
Nlist = list(map(int, input().split()))
count = 0
for n in Nlist:
    for i in range(2, n + 1):
        if i == n:
            count += 1
        elif n % i == 0:
            break

print(count)
