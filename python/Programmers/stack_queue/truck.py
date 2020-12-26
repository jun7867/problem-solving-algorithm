# 프로그래머스 다리를 지나는 트럭
# 스택/큐
bridge_length = 100
weight = 100
truck_weights = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]

count = 0
stack = []
time = []
while True:
    if stack:
        for t in time:
            if count - t == bridge_length:
                stack.pop(0)
    if not stack and not truck_weights:
        count += 1
        break

    if truck_weights:
        if weight - sum(stack) - truck_weights[0] >= 0:
            stack.append(truck_weights.pop(0))
            time.append(count)
    count += 1
print(count)

