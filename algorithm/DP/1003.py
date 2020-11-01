# 1003 피보나치 함수
# DP

import sys
input = sys.stdin.readline


def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    if d[n] != 0:
        return d[n]
    d[n] = fibo(n - 1) + fibo(n - 2)
    return d[n]


T = int(input())
d = [0] * 41

for i in range(T):
    N = int(input())
    fibo(N)
    if N == 0:
        print(1, 0)
    elif N == 1:
        print(0, 1)
    else:
        print(fibo(N - 1), fibo(N))
