# 10816 숫자 카드 2
# version 2 (hashmap)
import sys
input = sys.stdin.readline

N = int(input())
Nlist = list(map(int, input().strip().split()))
M = int(input())
Mlist = list(map(int, input().strip().split()))

hashmap = {}
for n in Nlist:
    if n in hashmap:
        hashmap[n] += 1
    else:
        hashmap[n] = 1

result = []
for m in Mlist:
    if m in hashmap:
        result.append(hashmap[m])
    else:
        result.append(0)
print(*result, sep=' ')

