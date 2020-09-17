#시물레이션 실버5
#나무 조각
num=list(map(int,input().split()))

while(1):
  for i in range(4):
    if num[i] > num[i+1]:
      temp=num[i+1]
      num[i+1]=num[i]
      num[i]=temp
      for j in num:
        print(j,end=' ') 
      print() 
  if num[0] < num[1] < num[2] < num[3] < num[4]:
    break


