# 10828 스택
import sys

N = int(sys.stdin.readline())
stack = []

for i in range(N):
    com = sys.stdin.readline().strip()
    if com[:4] == "push":
        stack.append(com[5:])
    elif com == "top":
        if len(stack) == 0:
            print(-1)
            continue
        print(stack[-1])
    elif com == "size":
        print(len(stack))
    elif com == "empty":
        if len(stack) == 0:
            print(1)
            continue
        print(0)
    elif com == "pop":
        if len(stack) == 0:
            print(-1)
            continue
        print(stack[-1])
        stack = stack[:-1]

