prev = ''
res = 0
for now in input():
    if prev == now:
        res += 5
    else:
        prev = now
        res += 10
print(res)