# 10866 덱
import sys

N = int(sys.stdin.readline())
deque = []

for i in range(N):
    com = sys.stdin.readline().strip()
    if com[:10] == "push_front":
        deque.append(com[11:])
    elif com[:9] == "push_back":
        deque.insert(0, com[10:])
    elif com == "front":
        if len(deque) == 0:
            print(-1)
            continue
        print(deque[-1])
    elif com == "back":
        if len(deque) == 0:
            print(-1)
            continue
        print(deque[0])
    elif com == "size":
        print(len(deque))
    elif com == "empty":
        if len(deque) == 0:
            print(1)
            continue
        print(0)
    elif com == "pop_front":
        if len(deque) == 0:
            print(-1)
            continue
        print(deque[-1])
        deque = deque[:-1]
    elif com == "pop_back":
        if len(deque) == 0:
            print(-1)
            continue
        print(deque[0])
        deque = deque[1:]

