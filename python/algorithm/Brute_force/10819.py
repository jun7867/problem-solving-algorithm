# 10819 차이를 최대로
# Brute force

import sys
from itertools import permutations

N = int(sys.stdin.readline())
Nlist = list(map(int, sys.stdin.readline().split()))
ans = 0
members = permutations(Nlist, N)

for member in members:
    member = list(member)
    sum = 0
    for i in range(N - 1):
        sum += abs(member[i] - member[i + 1])
    ans = max(sum, ans)
print(ans)
