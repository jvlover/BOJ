cnt = 2
while 1:
    s = input()
    if s[-1] == '?':
        break
    print(s[::cnt])
    cnt += 1