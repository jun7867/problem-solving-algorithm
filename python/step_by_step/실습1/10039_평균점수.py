#평균 점수
student = [0,0,0,0,0]
sum=0
average=0
for i in range(5):
	student[i]=int(input())
	if student[i] <40:
		student[i]=40

for i in range(5):
	sum +=student[i]
average=sum/5
print(round(average))

#round는 소숫점 반올림 해줌 

