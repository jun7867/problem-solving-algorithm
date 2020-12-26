def solution(array, commands):
    result = []
    for i, j, k in commands:
        temp = array[i - 1:j]
        temp.sort()
        result.append(temp[k - 1])
    return result
