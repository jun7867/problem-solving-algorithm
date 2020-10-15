# 10845 큐
import sys

N = int(sys.stdin.readline())
queue = []

for i in range(N):
    com = sys.stdin.readline().strip()
    if com[:4] == "push":
        queue.append(com[5:])
    elif com == "front":
        if len(queue) == 0:
            print(-1)
            continue
        print(queue[0])
    elif com == "back":
        if len(queue) == 0:
            print(-1)
            continue
        print(queue[-1])
    elif com == "size":
        print(len(queue))
    elif com == "empty":
        if len(queue) == 0:
            print(1)
            continue
        print(0)
    elif com == "pop":
        if len(queue) == 0:
            print(-1)
            continue
        print(queue[0])
        queue = queue[1:]

