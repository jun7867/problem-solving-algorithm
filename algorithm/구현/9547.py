# 9547 대통령 선거
import sys

T = int(sys.stdin.readline())
for _ in range(T):
    C, V = map(int, sys.stdin.readline().split())
    vote = []
    first = {}
    second = {}
    for _ in range(V):
        vote.append(list(map(int, sys.stdin.readline().rstrip().split())))
    for i in range(V):
        v = vote[i]  # 누가 첫번째 선호도인지.
        if first.get(v[0]):  # 만약에 이미 있는 거면 있는거에 + 1
            first[v[0]] = first[v[0]] + 1
        else:  # 기존에 있는 거면 1로 생성
            first[v[0]] = 1

    Finish = False
    for i, j in first.items():
        if j > V // 2:  # 과반수 이상이면 종료
            print(i, 1)
            Finish = True
    if Finish:
        continue

    WT = sorted(first.items(), key=lambda x: x[1], reverse=True)
    for i in range(2):  # 2등과 3번의 득표수는 항상 다르기에
        second[WT[i][0]] = 0  # 1등하고 2등의 후보가 저장.
    for secv in vote:  # secv는 위에서 입력한 vote 선호순
        for level in secv:  # level은 첫번째 득표번호
            # second.key() [0]과 [1]은 1등,2등 후보들인데 나오면 +1점씩
            if level == list(second.keys())[0] or level == list(second.keys())[1]:
                second[level] += 1
                break
    ans = max(second.keys(), key=(lambda x: second[x]))
    print(ans, 2)

