def solution(array, commands):
    result=list()
    for i in range(len(commands)):
        commandss=array[commands[i][0]-1:commands[i][1]]
        sort_com=sorted(commandss)
        result.append(sort_com[commands[i][2]-1])
    return result
