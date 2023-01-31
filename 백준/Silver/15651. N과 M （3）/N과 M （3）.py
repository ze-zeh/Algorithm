from itertools import product

n, m = map(int, input().split())
for i in product([j for j in range(1, n + 1)], repeat=m):
    print(' '.join(map(str, i)))
