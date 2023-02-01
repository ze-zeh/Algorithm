n, s = map(int, input().split())
arr = list(map(int, input().split()))
count = 0


def solve(idx, sum):
    global count

    if idx >= n:
        return

    solve(idx + 1, sum)

    sum += arr[idx]

    if sum == s:
        count += 1

    solve(idx + 1, sum)


solve(0, 0)
print(count)
