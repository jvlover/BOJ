for _ in range(int(input())):
    name = ''
    ans = 0
    for i in range(int(input())):
        a, b = input().split()
        b = int(b)
        if ans < b:
            name = a
            ans = b
    print(name)