from collections import deque
def solution(arr):
    arr=deque(arr)
    result=[]
    while len(arr) >= 1:
        temp = arr.popleft()
        if len(arr) == 0:
            result.append(temp)
            break
        elif temp != arr[0]:
            result.append(temp)
    return result
