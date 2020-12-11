# 1874 스택 수열

import sys
input = sys.stdin.readline

n = int(input())
count = 1
stack = []
result = []
for i in range(n):
    num = int(input())
    while count <= num:  # count <= num 이 핵심이다. (count를 다시 초기화 안시켜줌.)
        stack.append(count)
        result.append('+')
        count += 1
    if stack[-1] == num:
        stack.pop()
        result.append('-')

if stack:
    print('NO')
else:
    for s in result:
        print(s)
