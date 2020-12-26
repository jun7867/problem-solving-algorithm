k = 2
score = [1300000000, 700000000, 668239490, 618239490, 568239490,
         568239486, 518239486, 157658638, 157658634, 100000000, 100]
scoreSort = sorted(score, reverse=True)
count = {}
minus = [-1]
result = 0
for i in range(len(score)-1):
    minus.append(scoreSort[i]-scoreSort[i+1])
for i in minus:
    try:
        count[i] += 1
    except:
        count[i] = 1
# print(count)
temp = sorted(count.items(), key=lambda x: x[1])
print(temp)
deleteList = []
for i in range(len(count)):
    if temp[i][1] >= k:
        deleteList.append((temp[i][0]))
print(deleteList)

print(minus)

cc = 0
for i in range(1, len(minus)):
    if minus[i] in deleteList and minus[i-1] in deleteList:
        cc += 1
    elif minus[i] in deleteList:
        cc += 2

print(len(minus)-cc)
