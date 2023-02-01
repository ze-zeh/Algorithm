n, s = map(int, input().split())
arr = list(map(int, input().split()))
count = 0


def solve(idx, sum):
    global count

    if idx == n:
        if sum == s:
            count += 1
        return
    solve(idx + 1, sum)
    solve(idx + 1, sum + arr[idx])


solve(0, 0)
if s == 0:
    count -= 1
print(count)
