# 1966 프린터 큐

import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    N, M = map(int, input().strip().split())
    N_list = list(map(int, input().strip().split()))
    count = 0
    target = M
    while True:
        check = N_list.pop(0)
        target -= 1
        if not N_list:
            count += 1
            print(count)
            break
        elif check >= max(N_list):
            count += 1
            if target == -1:
                print(count)
                break
        else:
            N_list.append(check)
            if target == -1:
                target += len(N_list)

