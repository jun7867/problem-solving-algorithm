# 체육복
# Programmers

n = 5
lost = [2, 4]
reserve = [1, 3, 5]

set_reserve = reserve - lost
set_lost = set(lost) - set(reserve)

for r in set_reserve:
    if r - 1 in set_lost:
        set_lost.remove(r - 1)
    elif r + 1 in set_lost:
        set_lost.remove(r + 1)
print(n - len(set_lost))

