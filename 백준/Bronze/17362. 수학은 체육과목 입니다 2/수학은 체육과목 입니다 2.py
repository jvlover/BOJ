n = int(input())
if n%8 == 0:
    print(2)
elif n%4 == 3:
    print(3)
elif n%8 == 6:
    print(4)
else:
    print(n%8)