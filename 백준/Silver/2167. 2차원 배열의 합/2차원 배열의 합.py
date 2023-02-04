n, m = map(int, input().split())
arr = []
dp = [[0] * (m + 1) for i in range(n + 1)]

for i in range(n):
    arr.append(list(map(int, input().split())))

for i in range(1, n + 1):
    for j in range(1, m + 1):
        dp[i][j] = arr[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1]

k = int(input())

for i in range(k):
    w, x, y, z = map(int, input().split())
    print(dp[y][z] - dp[y][x - 1] - dp[w - 1][z] + dp[w - 1][x - 1])
