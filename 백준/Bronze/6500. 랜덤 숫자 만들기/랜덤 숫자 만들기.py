import sys
input = sys.stdin.readline
while 1:
    n = int(input())
    if not n:
        break
    hs = set()
    hs.add(n)
    n *= n
    while 1:
        s = str(n)
        while len(s) < 8:
            s = '0'+s
        n = int(s[2:6])
        if n in hs:
            break
        hs.add(n)
        n *= n
    print(len(hs))