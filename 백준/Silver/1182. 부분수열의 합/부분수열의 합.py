from itertools import combinations

n, s = map(int, input().split())
arr = list(map(int, input().split()))
count = 0

for i in range(1, n + 1):
    c = combinations(arr, i)

    for x in c:
        if sum(x) == s:
            count += 1

print(count)
