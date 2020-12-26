# 10815 숫자카드
# Sort
import sys

def binary_search(array, value, low, high):
    if low > high:
        return False
    mid = (low+high) // 2

    if value < array[mid]:
        return binary_search(array, value, low, mid-1)
    elif value > array[mid]:
        return binary_search(array, value, mid+1, high)
    else:
        return True

N = int(sys.stdin.readline())
Nlist = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
Mlist = list(map(int, sys.stdin.readline().split()))

Nlist.sort()

for i in Mlist:
    if binary_search(Nlist, i, 0, N-1):
        print(1, end=" ")
    else:
        print(0, end=" ")
