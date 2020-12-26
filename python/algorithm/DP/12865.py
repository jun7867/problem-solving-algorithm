# 12865 평범한 배낭
# DP Knapsack
import sys
input = sys.stdin.readline

n, k = map(int, input().strip().split())
W = []
V = []
for i in range(n):
    w, v = map(int, input().strip().split())
    W.append(w)  # 각 물건 무게
    V.append(v)  # 각 물건 가치

dp = [[0 for x in range(k + 1)] for x in range(n + 1)]

for i in range(1, n + 1):
    for w in range(1, k + 1):  # w는 배당 무게
        if W[i - 1] > w:
            dp[i][w] = dp[i - 1][w]
        else:
            dp[i][w] = max(V[i - 1] + dp[i - 1][w - W[i - 1]], dp[i - 1][w])
print(dp[n][k])
