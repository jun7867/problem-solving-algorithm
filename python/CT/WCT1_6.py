# WCT1-6
from datetime import datetime, timedelta

total = 2000
logs = [
    'woni request 09:12:29',
    'brown request 09:23:11',
    'brown leave 09:23:44',
    'jason request 09:33:51',
    'jun request 09:33:56',
    'cu request 09:34:02',
]
logList = []
success = []

for s in logs:
    logList.append(s.split(' '))
ing = False
for name, log, times in logList:
    if len(success) > total:
        break
    #request일때
    if log == 'request':
        #이미 들어가있는게 있으면
        if ing == True:
            now = datetime.strptime(times, '%H:%M:%S')
            for pN, pL, pT in logList:
                if pN == success[-1] and pL == 'request':
                    prev = datetime.strptime(pT, '%H:%M:%S')
                    break
            gap = now - prev
            # 차가 1분 이상이면 진행중이 아니다.
            if gap.seconds // 60 > 0:
                ing = False

        #진행중인게 없으면 일단 넣어주고 ing=Ture
        if ing == False:
            success.append(name)
            ing = True
    #leave일때
    elif log == 'leave':
        #진행안하고 있다고 표시 + 넣어준거 빼주기
        ing = False
        if len(success) > 0:
            success.remove(name)

print(sorted(success))
