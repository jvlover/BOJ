i = input()
a = '7' in i
b = int(i)%7
if not a and b:
    print(0)
elif not a and not b:
    print(1)
elif a and b:
    print(2)
else:
    print(3)