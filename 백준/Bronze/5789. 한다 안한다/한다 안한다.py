n = int(input())
for _ in range(n):
    s = input()
    a = len(s)//2
    print('Do-it' if s[a] == s[a-1] else 'Do-it-Not')