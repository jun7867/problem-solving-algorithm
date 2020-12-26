def solution(answers):
    a=[1,2,3,4,5] 
    b=[2,1,2,3,2,4,2,5] 
    c=[3,3,1,1,2,2,4,4,5,5] 
    total=[0,0,0]
    answer=[]
    for i in range(len(answers)):
        if a[i % len(a)] == answers[i]:
            total[0]+=1
        if b[i % len(b)] == answers[i]:
            total[1]+=1
        if c[i % len(c)] == answers[i]:
            total[2]+=1

    max_score = max(total)
    for i in range(3):
        if total[i] == max_score:
            answer.append(i + 1)
    return answer
