# 신입 사원
import sys

def greedy(records,n):
    count=1
    min=records[0][1] # 서류 면접자 1등의 인터뷰 점수

    for i in range(1,n):
      #서류 면접 점수 더 높은사람의 인터뷰 점수보다 현재 인터뷰 점수가 더 높을 때
      if records[i][1] < min: 
        min=records[i][1]
        count+=1
    print(count)


T=int(sys.stdin.readline().strip())
for i in range(T):
    N=int(sys.stdin.readline().strip())
    records=[]
    for j in range(N):
        report, interview=map(int,sys.stdin.readline().strip().split())
        records.append([report,interview])
    records=sorted(records,key=lambda record: record[0])
  
    greedy(records,N)
