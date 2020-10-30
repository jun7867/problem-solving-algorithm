# 9663 N-Queen
# BackTracking
import sys

input = sys.stdin.readline

# 셋중 하나라도 안된다고(1) 체크가 되어있으면 false
def check(row, col):
    if Col[col] == 1: #세로줄 확인
        return False
    if Ldig[row + col] == 1: #왼쪽 대각선 확인
        return False
    if Rdig[row - col + N - 1] == 1: #오른쪽 대각선 확인
        return False
    return True


def dfs(row):
    global result
    #row가 끝까지 도달하면 +1점
    if row == N:
        result += 1
        return
    #row는 검사안하고(한줄에 하나니까) col 한개씩 내린다.
    for col in range(N):
        #다음줄에 도달하는데 맞는 값이 있다면
        if check(row, col):
            Col[col] = 1 
            Ldig[row + col] = 1
            Rdig[row - col + N - 1] = 1
            # 이줄을 채우고 dfs 호풀(자식 노드로)
            dfs(row + 1)
            #return이 되었을때 새롭게 초기화 하기 위해 0으로.
            Col[col] = 0
            Ldig[row + col] = 0
            Rdig[row - col + N - 1] = 0


N = int(input())
Col = [0] * N
Rdig = [0] * (2 * N - 1)  # 대각선의 개수는 2*N -1개이다. 오른쪽 대각선
Ldig = [0] * (2 * N - 1)  # 왼쪽 대각선
result = 0
dfs(0)

print(result)
