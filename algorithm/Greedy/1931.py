#회의실배정
#자주 쓰이고 어려운 개념이니 한번 더 볼것.

def solution(list_N):
  answer=0
  time=0

  for i in range(len(list_N)):
    if time <= list_N[i][0]:
      time = list_N[i][1]
      answer +=1

  return answer



N=int(input())
list_N=[]

for i in range(N):
  start,end=map(int,input().split())
  list_N.append([start,end])

#1) 끝나는 시간이 빠른순으로 정렬 -> 2) 시작하는 시간의 오름차순 
list_N=sorted(list_N,key=lambda x: (x[1], x[0]))

print(solution(list_N))


