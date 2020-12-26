# 크레인 인형뽑기 게임
# 프로그래머스 level1 - stack
def solution(board, moves):
    stack = []
    count = 0
    for m in moves:
        for i in range(len(board)):
            if board[i][m - 1] != 0:
                if stack and stack[-1] == board[i][m - 1]:
                    stack.pop()
                    count += 2
                else:
                    stack.append(board[i][m - 1])
                board[i][m - 1] = 0
                break
    return count
