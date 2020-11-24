# 프로그래머스 고득점 Kit
# # 스택/큐 : 프린터
from collections import deque

priorities = [1, 2, 3]
location = 0

count = 0
while priorities:
    if location == 0:
        if priorities[0] < max(priorities):
            priorities.append(priorities.pop(0))
            location = len(priorities) - 1
        else:
            print(count + 1)
            break
    else:
        if priorities[0] < max(priorities):
            priorities.append(priorities.pop(0))
            location -= 1
        else:
            priorities.pop(0)
            location -= 1
            count += 1

