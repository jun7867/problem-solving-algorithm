# 2485 가로수
# math
# 최대공약수
import sys

input = sys.stdin.readline


def GCD(a, b):
    while b != 0:
        a, b = b, a % b
    return a


N = int(input())
tree = []
dis = []
for _ in range(N):
    tree.append(int(input()))
for i in range(N - 1):
    dis.append(abs(tree[i + 1] - tree[i]))

GCDnow = dis[0]
for i in range(len(dis)):
    GCDnow = GCD(GCDnow, dis[i])

count = 0
for d in dis:
    count += d // GCDnow - 1
print(count)
