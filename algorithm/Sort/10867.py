# 10867 중복 빼고 정렬하기

import sys
input = sys.stdin.readline

N = int(input())
Nlist = list(map(int, input().strip().split()))
Nlist = list(set(Nlist))
Nlist.sort()
print(*Nlist, sep=" ")

