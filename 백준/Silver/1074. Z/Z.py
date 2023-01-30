N, r, c = map(int, input().split())


def z(n, row, col):
    if n == 0:
        return 0
    half = 2 ** (n - 1)
    if row < half and col < half:
        return z(n - 1, row, col)
    if row < half and col >= half:
        return half ** 2 + z(n - 1, row, col - half)
    if row >= half and col < half:
        return 2 * half ** 2 + z(n - 1, row - half, col)
    return 3 * half ** 2 + z(n - 1, row - half, col - half)


print(z(N, r, c))
