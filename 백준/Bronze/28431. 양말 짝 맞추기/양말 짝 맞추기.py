a = set()
for _ in range(5):
    i = int(input())
    if i in a:
        a.remove(i)
    else:
        a.add(i)
print(*a)