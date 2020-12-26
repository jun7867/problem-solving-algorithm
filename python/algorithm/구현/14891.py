# 14891 톱니바퀴
import sys


def rotation(n, d):
    isRotate = [False for i in range(4)]
    direction = [0 for i in range(4)]
    isRotate[n] = True
    direction[n] = d
    tempn = n
    tempd = d
    # 오른쪽의 경우 확인 (끝까지 안가도 중간에 틀리면 break돼서 결국 다음꺼 비교)
    for i in range(n + 1, 4):
        if t[tempn][2] != t[i][6]:  # 밎으면 다음칸도 확인 반복
            isRotate[i] = True
            tempd = -tempd
            direction[i] = tempd
            tempn = i
        else:
            break
    tempn = n
    tempd = d
    for i in range(n - 1, -1, -1):
        if t[tempn][6] != t[i][2]:
            isRotate[i] = True
            tempd = -tempd
            direction[i] = tempd
            tempn = i
        else:
            break
    for i in range(4):
        if isRotate[i]:
            if direction[i] == 1:
                temp = t[i].pop()
                t[i] = [temp] + t[i]
            else:
                temp = t[i][0]
                del t[i][0]
                t[i].append(temp)


t = []
r = []
for _ in range(4):
    t.append(list(sys.stdin.readline().strip()))
k = int(sys.stdin.readline().strip())

for _ in range(k):
    a, b = map(int, sys.stdin.readline().strip().split())
    r.append([a - 1, b])
for n, d in r:
    rotation(n, d)
result = 0

for i in range(4):
    if t[i][0] == "1":
        result += 2 ** i
print(result)

