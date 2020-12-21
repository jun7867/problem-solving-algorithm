def solution(a, b):
    month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31]
    week = ["THU","FRI","SAT","SUN","MON","TUE","WED"]
    day = 0
    for i in range(a):
        day += month[i]
    day += b
    
    return week[day%7]
