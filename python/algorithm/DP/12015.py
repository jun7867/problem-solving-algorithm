# 12015
# 가장 큰 증가 부분 수열2 LIS (+이진탐색)

import sys
input = sys.stdin.readline
from bisect import bisect_left

n = int(input())
A = list(map(int, input().split()))
dp = [0]

for a in A:
    print(dp, a)
    if dp[-1] < a:
        dp.append(a)
    else:
        print(bisect_left(dp, a))
        dp[bisect_left(dp, a)] = a

print(len(dp) - 1)

# 이 방법은 실제로 가장 긴 부분 수열을 구한다기 보다는 가장 긴 수열의 전체 길이만 구할 수 있다.

