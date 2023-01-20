a, b, c = map(int, input().split())


def multi(a, n):
    if n == 1:
        return a % c
    else:
        if n % 2 == 0:
            return multi(a, n // 2) ** 2 % c
        else:
            return multi(a, n // 2) ** 2 * a % c


print(multi(a, b))
