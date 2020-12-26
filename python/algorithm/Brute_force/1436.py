#영화감독 숌 brute

N=int(input())
N_list=[]
devil='666'
i=1
while True:
	if devil in str(i):
		N_list.append(i)
		if len(N_list) > N:
			break
	i+=1

sorted(N_list)

print(N_list[N-1])
	
	
