# 2138 전구와 스위치
# Greedy
import sys


def change_OnOFF(value):
    if value == "0":
        value = "1"
    else:
        value = "0"
    return value


def change(n, t):
    if n == 0:
        t[0] = change_OnOFF(t[0])
        t[1] = change_OnOFF(t[1])
    elif n == N - 1:
        t[-1] = change_OnOFF(t[-1])
        t[-2] = change_OnOFF(t[-2])
    else:
        t[n - 1] = change_OnOFF(t[n - 1])
        t[n] = change_OnOFF(t[n])
        t[n + 1] = change_OnOFF(t[n + 1])
    return t


input = sys.stdin.readline
N = int(input())
current = []
result = []
count = 0
current = list(input().strip())
result = list(input().strip())
temp = current[:]
count_list = []
isEnd = False
if current == result:
    print(0)
else:
    # 첫번째 스위치를 안누르는 경우
    for i in range(1, N):
        # 바로 전 값이 다를 경우
        if temp == result:
            print(count)
            isEnd = True
            break
        elif i == N - 1:
            temp = change(i, temp)
            if temp == result:
                count += 1
                print(count)
                isEnd = True
                break
        elif temp[i - 1] != result[i - 1]:
            temp = change(i, temp)
            count += 1
    if isEnd == False:
        temp = current[:]
        temp = change(0, temp)
        count = 1
        # 처음꺼 바꿨는데 맞췄을 경우
        if temp == result:
            print(1)
        else:
            for i in range(1, N):
                if temp == result:
                    print(count)
                    break
                elif i == N - 1:
                    temp = change(i, temp)
                    if temp == result:
                        count += 1
                        print(count)
                        break
                    else:
                        print(-1)
                        break
                elif temp[i - 1] != result[i - 1]:
                    temp = change(i, temp)
                    count += 1

