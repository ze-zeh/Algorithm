def func(start, end, n):
    if n == 1:
        print(start, end)
        return
    func(start, 6 - start - end, n - 1)
    print(start, end)
    func(6 - start - end, end, n - 1)


k = int(input())
print(2 ** k - 1)
func(1, 3, k)
