# WCT1_7

cryptogram = "zyelleyz"

check = True

listgram = list(cryptogram)
while check:
    check = False
    while '*' in listgram:
        listgram.remove('*')

    for i in range(len(listgram) - 1):
        check_i = False
        count = 1
        while True:
            if i + count >= len(listgram):
                break
            if listgram[i] != listgram[i + count]:
                break
            listgram[i + count] = '*'
            check_i = True
            count += 1
        if check_i == True:
            listgram[i] = '*'
            check = True
print("".join(listgram))
