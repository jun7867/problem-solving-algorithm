# 14728 벼락치기
# DP Knapsack
import sys
input = sys.stdin.readline

n, t = map(int, input().strip().split())
K = []
S = []
for i in range(n):
    k, s = map(int, input().strip().split())
    K.append(k)  # 각 문제 공부시간
    S.append(s)  # 각 문제 배점

dp = [[0 for x in range(t + 1)] for x in range(n + 1)]

for i in range(1, n + 1):
    for s in range(1, t + 1):  # w는 배점
        if K[i - 1] > s:
            dp[i][s] = dp[i - 1][s]
        else:
            dp[i][s] = max(S[i - 1] + dp[i - 1][s - K[i - 1]], dp[i - 1][s])
print(dp[n][t])
