res = 0
t = int(input())
l = list(map(int, input().split())) + [0]*(5-t)
if l[0] > l[2]:
    res += (l[0]-l[2]) * 508
else:
    res += (l[2]-l[0]) * 108
if l[1] > l[3]:
    res += (l[1]-l[3]) * 212
else:
    res += (l[3]-l[1]) * 305
if l[4] > 0:
    res += l[4] * 707
print(res*4763)