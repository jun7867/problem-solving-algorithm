# 2417 정수 제곱근
import math

n = int(input())
k = round(math.sqrt(n))

if n > k**2:
    print(k+1)
else:
    print(k)

