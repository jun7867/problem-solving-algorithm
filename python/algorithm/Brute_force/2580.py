# 2580 스도쿠 (골4)
# BackTracking

import sys
input = sys.stdin.readline


def backTracking(idx):
    if idx == len(zeros):
        for row in board:
            print(*row)
        sys.exit(0)
    x = zeros[idx][0]
    y = zeros[idx][1]
    dx = (x // 3) * 3
    dy = (y // 3) * 3
    num_list = [False] + [True for _ in range(9)]
    for i in range(9):
        #가로 검사
        if board[x][i] != 0:
            num_list[board[x][i]] = False
        #세로 검사
        if board[i][y] != 0:
            num_list[board[i][y]] = False
    # 3*3 검사
    for i in range(dx, dx + 3):
        for j in range(dy, dy + 3):
            if board[i][j] != 0:
                num_list[board[i][j]] = False
    isPossible = []
    for i, k in enumerate(num_list):
        if k:
            isPossible.append(i)
    for p in isPossible:
        board[x][y] = p
        backTracking(idx + 1)
        board[x][y] = 0


board = [list(map(int, input().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9)
         if board[i][j] == 0]  # 0이 들어있는 i,j값 따로 저장

backTracking(0)

