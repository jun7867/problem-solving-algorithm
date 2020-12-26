def solution(n, lost, reserve):
    # 여분있는 사람이 체육복을 잃어버릴 수도 있으니 둘다 지워준다.
    set_reserve=set(reserve)-set(lost)
    set_lost=set(lost)-set(reserve)
    
    for i in set_reserve:
        #왼쪽에 있는 사람이 lost에 속해있다면 빌려줄 수 있음
        if i-1 in set_lost:
            set_lost.remove(i-1)
        #오른쪽에 있는 사람이 lost에 속해있다면 빌려줄 수 있음
        elif i+1 in set_lost:
            set_lost.remove(i+1)
        
    answer = n-len(set_lost)
    return answer

