# 2661 좋은 수열

import sys
input = sys.stdin.readline


def check(result, count):
    for k in range(count):
        sliceTemp = result[k:]
        for i in range(1, len(sliceTemp) // 2 + 1):
            checkV = sliceTemp[:i]
            if checkV == sliceTemp[i:i + i]:
                return False
    return True


def backTracking(count):
    if not check(result, count):
        return -1
    if count == N:
        print(*result, sep="")
        return 0
    # 핵심. (1,2,3 순으로 진행하기에 결국엔 먼저 되는값이 최소값)
    for i in range(1, 4):
        result.append(i)
        if backTracking(count + 1) == 0:
            return 0
        result.pop()


N = int(input())
result = []
backTracking(0)

