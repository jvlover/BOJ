s = input()
l = len(s)
n = int(s)
ans = 0
num = 9
for i in range(1, l):
    ans += i*num
    num *= 10
minus = int("9"*(l-1)) if l > 1 else 0
print((ans+(n-minus)*l)%1234567)