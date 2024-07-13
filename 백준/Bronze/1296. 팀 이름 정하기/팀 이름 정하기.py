name = input()
n = int(input())
sl = sorted([input() for _ in range(n)])
mx = idx = 0
for i in range(n):
    l = name.count("L")+sl[i].count("L")
    o = name.count("O")+sl[i].count("O")
    v = name.count("V")+sl[i].count("V")
    e = name.count("E")+sl[i].count("E")
    tmx = ((l+o)*(l+v)*(l+e)*(o+v)*(o+e)*(v+e))%100
    if mx < tmx:
        mx = tmx
        idx = i
print(sl[idx])