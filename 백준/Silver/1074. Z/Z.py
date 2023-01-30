N, r, c = map(int, input().split())


def z(n, row, col):
    if n == 0:
        return 0
    return 2 * (row % 2) + (col % 2) + 4 * z(n - 1, int(row / 2), int(col / 2))


print(z(N, r, c))
