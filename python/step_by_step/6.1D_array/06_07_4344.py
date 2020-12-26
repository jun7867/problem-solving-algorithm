 #1D array - 4344
 #평균은 넘겠지 That's more than average

TN=int(input())
score_list=[]
percent=[]
for i in range(TN):
     score_list=list(map(int,input().split()))
     real_len=len(score_list)-1

     total=0
     aver=0.0
     count=0
     for j in range(real_len):
         total+=score_list[j+1]
     aver=total/score_list[0]


     for k in range(real_len):
         if score_list[k+1] > aver :
             count+=1
     percent.append((count*100)/real_len)
for i in range(TN):
    print(format(percent[i],".3f"),end='') #rounding up to n'th
    print("%")
