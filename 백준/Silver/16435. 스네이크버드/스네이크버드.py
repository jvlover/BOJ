n, l = map(int, input().split())
for i in sorted(list(map(int, input().split()))):
    if i <= l:
        l += 1
print(l)