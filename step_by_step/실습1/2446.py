#별 찍기 -9
N=int(input())

for i in range(1,N+1):
	star='*' * (2*N-2*i+1)
	space=' ' * (i-1)
	print(space + star)

for i in range(1,N):
	space=' ' * (N-1-i)
	star='*' * (2 * i +1)
	print(space + star)
 
