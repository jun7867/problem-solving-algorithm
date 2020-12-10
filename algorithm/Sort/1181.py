# 1181 단어 정렬

import sys
input = sys.stdin.readline

N = int(input())
word = []
for i in range(N):
    s = input().strip()
    lenS = len(s)
    word.append((s, lenS))
word_list = list(set(word))

word_list.sort(key=lambda x: (x[1], x[0]))
for word in word_list:
    print(word[0])

