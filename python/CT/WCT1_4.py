# WCT1-4

pobi = [99, 102]
crong = [211, 212]
result = 0

if pobi[0] % 2 == 0 or pobi[1] % 2 == 1 or crong[0] % 2 == 0 or crong[
        1] % 2 == 1 or abs(
            pobi[0] - pobi[1] != 1) or abs(crong[0] - crong[1]) != 1:
    result = -1
else:
    pobiList = []
    crongList = []
    a = 0
    b = 0
    c = 0
    for i in range(2):
        if pobi[i] >= 100:
            a = pobi[i] // 100
            pobi[i] -= 100 * (pobi[i] // 100)
        if pobi[i] >= 10:
            b = pobi[i] // 10
            pobi[i] -= 10 * (pobi[i] // 10)
            c = pobi[i]
        pobiList.append(a + b + c)
        if a == 0 and b == 0:
            pobiList.append(c)
        elif a == 0:
            pobiList.append(b * c)
        else:
            pobiList.append(a * b * c)

    a = 0
    b = 0
    c = 0
    for i in range(2):
        if crong[i] >= 100:
            a = crong[i] // 100
            crong[i] -= 100 * (crong[i] // 100)
        if crong[i] >= 10:
            b = crong[i] // 10
            crong[i] -= 10 * (crong[i] // 10)
            c = crong[i]
        crongList.append(a + b + c)
        if a == 0 and b == 0:
            crongList.append(c)
        elif a == 0:
            crongList.append(b * c)
        else:
            crongList.append(a * b * c)

    if max(pobiList) > max(crongList):
        result = 1
    elif max(pobiList) < max(crongList):
        result = 2
    elif max(pobiList) == max(crongList):
        result = 0
    else:
        result = -1

print(result)
