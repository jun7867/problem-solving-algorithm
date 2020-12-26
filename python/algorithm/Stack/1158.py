# 1158 요세푸스 문제

import sys
input = sys.stdin.readline

n, k = map(int, input().strip().split())
nList = [i for i in range(1, n + 1)]

temp = 0
stack = []
while nList:
    temp = (temp + (k - 1)) % len(nList)
    p = nList.pop(temp)
    stack.append(str(p))
print("<%s>" % (", ".join(stack)))

