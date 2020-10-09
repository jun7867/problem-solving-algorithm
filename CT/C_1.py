N = 999123

answer = ""
dic = {}
for nth in range(2, 10):
    answer = ""
    tempN = N
    multi = 1

    while tempN // nth >= 1:
        remain = tempN % nth
        tempN = tempN // nth
        answer += str(remain)
        if tempN < nth:
            answer = str(tempN) + answer
        for i in answer:
            if i != '0':
                multi *= int(i)
        dic[nth] = multi

k = sorted(dic.items(), key=lambda x: x[1])
result = []
result.append(k[-1][0])
result.append(k[-1][1])
print(result)


