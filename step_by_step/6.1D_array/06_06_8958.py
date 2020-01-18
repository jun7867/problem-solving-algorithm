#1D array 6 
#OX퀴즈

a=int(input())

Final=[]
for i in range(a):
    list_OX=input()
    score=0
    count=0
    for j in range(len(list_OX)):
        if list_OX[j]=="O":
            count+=1
            score+=count
        else:
            count=0
    Final.append(score)
for i in range(a):
    print(Final[i])

