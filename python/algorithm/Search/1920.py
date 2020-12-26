#binary search
def BinarySearch(arr, val, low, high):
    if low > high:
        return False
    
    mid = (low + high) // 2
    if arr[mid] > val:
        return BinarySearch(arr, val, low, mid - 1)
    elif arr[mid] < val:
        return BinarySearch(arr, val, mid + 1, high)
    else:
        return True

import sys

N=int(sys.stdin.readline())
listN=list(map(int,sys.stdin.readline().rstrip().split()))
M=int(sys.stdin.readline())
listM=list(map(int,sys.stdin.readline().rstrip().split()))

listN.sort()

for i in listM:
  if BinarySearch(listN,i,0,N-1):
    print(1)
  else:
    print(0)

