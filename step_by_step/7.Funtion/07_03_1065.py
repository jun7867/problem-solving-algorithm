#Funtion 07 - 03 1065
#한수
#python3

def hansu(a):
    if a<100:
        return 1
    elif a<1000:
        key=str(a)
        di_1=int(key[0])-int(key[1])
        di_2=int(key[1])-int(key[2])
        if di_1==di_2:
            return 1
        else:
            return 0
    else:
        return 0


N=int(input())
count=0
for i in range(1,N+1):
    count+=hansu(i)
print(count)
