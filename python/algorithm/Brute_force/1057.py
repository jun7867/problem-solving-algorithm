# 1057 토너먼트
# brute force

import sys

n, a, b = map(int, (sys.stdin.readline().split()))

Tround = 0
if n % 2 != 0:
    Tround = 1
while True:
    if n == 1:
        break
    n = n // 2
    Tround += 1
count = 0

for i in range(Tround):
    if ((a + 1) // 2 - (b + 1) // 2 == 0) and abs(b - a) == 1:
        count += 1
        break
    else:
        a = (a + 1) // 2
        b = (b + 1) // 2
        count += 1

print(count)

