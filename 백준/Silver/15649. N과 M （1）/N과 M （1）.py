N, M = map(int, input().split())
arr = []


def solution():
    if len(arr) == M:
        print(' '.join(map(str, arr)))
        return

    for i in range(1, N + 1):
        if i not in arr:
            arr.append(i)
            solution()
            arr.pop()


solution()
