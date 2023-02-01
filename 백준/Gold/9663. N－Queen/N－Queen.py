n = int(input())
col = [0] * 40
left = [0] * 40
right = [0] * 40
count = 0


def queen(cur):
    global count

    if cur == n:
        count += 1
        return

    for i in range(n):
        if col[i] or left[i + cur] or right[cur - i + n - 1]:
            continue
        col[i] = 1
        left[i + cur] = 1
        right[cur - i + n - 1] = 1
        queen(cur + 1)
        col[i] = 0
        left[i + cur] = 0
        right[cur - i + n - 1] = 0


queen(0)
print(count)
