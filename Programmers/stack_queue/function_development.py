stack = []
    result = []
    
    for i in range(len(progresses)):
        remain = 100 - progresses[i]
        if remain % speeds[i] == 0:
            day = remain // speeds[i]
        else:
            day = remain // speeds[i] + 1
        stack.append(day)

    front = 0
    for idx in range(len(progresses)):
        if stack[front] < stack[idx]:
            result.append(idx-front)
            front = idx
    result.append(len(progresses)-front)
