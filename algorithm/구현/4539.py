# 4539 반올림

import sys

n = int(sys.stdin.readline())

for i in range(n):
    test = list(map(int, sys.stdin.readline().strip()))
    if len(test) == 1:
        print(*test, sep="")
        continue
    for j in range(len(test) - 1, 0, -1):
        if test[j] >= 5:
            test[j - 1] += 1
            test[j] = 0
        else:
            test[j] = 0
    print(*test, sep="")

