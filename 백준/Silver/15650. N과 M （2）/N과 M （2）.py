N, M = map(int, input().split())
arr = []


def solution(k):
    if len(arr) == M:
        print(' '.join(map(str, arr)))
        return

    for i in range(k, N + 1):
        if i not in arr:
            arr.append(i)
            solution(i)
            arr.pop()


solution(1)
