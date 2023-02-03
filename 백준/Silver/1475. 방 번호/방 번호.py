n = input()
arr = [0] * 10

for i in n:
    arr[int(i)] += 1

if (arr[6] + arr[9]) % 2 == 0:
    arr[6] = (arr[6] + arr[9]) // 2
else:
    arr[6] = (arr[6] + arr[9]) // 2 + 1

arr[9] = 0

print(max(arr))
