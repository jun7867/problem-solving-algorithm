# 10816 숫자 카드 2

import sys
input = sys.stdin.readline
from collections import Counter

N = int(input())
Nlist = list(map(int, input().strip().split()))
M = int(input())
Mlist = list(map(int, input().strip().split()))

C = Counter(Nlist)
result = []
for m in Mlist:
    if m in C:
        result.append(C[m])
    else:
        result.append(0)
print(*result, sep=' ')

