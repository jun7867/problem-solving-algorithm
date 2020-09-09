N, M=map(int,input().split())
r, c, d = map(int,input().split())
room = [list(map(int, input().split())) for _ in range(N)]


#북,동,남,서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

#북동남서 0123
direction=[3,0,1,2]

#현재위치 청소
x=r
y=c
count=1;
room[r][c]=-1
while(True):
  #2 왼쪽 확인
  #2.a
  #0->3 / 1 -> 0 / 2-> 1 / 3 -> 2
  dc=d
  for i in range(4):
    empty=0
    dc=direction[dc]
    nx=x+dx[dc]
    ny=y+dy[dc]
    #유효범위 + 빈칸
    if(0<=nx<N and 0<=ny<M and room[nx][ny] ==0):
      count+=1
      x=nx
      y=ny
      room[nx][ny]=-1
      d=dc
      empty=1
      break
  #후진
  if(empty==0):
    if(d==0): x+=1
    elif(d==1): y-=1
    elif(d==2): x-=1
    elif(d==3): y+=1
    #후진할게 벽이면
    if(room[x][y]==1):
      break
print(count)

 


