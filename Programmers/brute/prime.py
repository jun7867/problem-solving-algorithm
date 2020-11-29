from itertools import permutations
def solution(numbers):
    numberList = list(numbers)
    numberList.sort(reverse=True)
    maxV = int("".join(numberList))
    prime = []
    # 에라토스테네스의 체로 maxV까지의 소수 구해서 prime에 저장
    array = [False, False] + [True] * (maxV - 1)
    for i in range(2, maxV + 1):
        if array[i]:
            prime.append(i)
        for j in range(i * i, maxV + 1, i):
            array[j] = False
    # 순열을 이용해서 모든 경우의 수 찾기
    perList = []
    result = []
    for k in range(1, len(numbers) + 1):
        perList = list(map(''.join, permutations(numberList, k)))
        for p in list(set(perList)):
            if int(p) in prime:
                result.append(int(p))
    # 동일한 수 중복 제거 예를들어, 11 011
    result = set(result)
    return len(result)
