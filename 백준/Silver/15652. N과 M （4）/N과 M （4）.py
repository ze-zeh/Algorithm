N, M = map(int, input().split())
arr = []


def solution(idx):
    if len(arr) == M:
        print(' '.join(map(str, arr)))
        return

    for i in range(idx, N + 1):
        arr.append(i)
        solution(i)
        arr.pop()


solution(1)
