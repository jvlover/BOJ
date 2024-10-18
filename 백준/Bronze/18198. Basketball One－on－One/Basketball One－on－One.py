a = b = 0
s = input()
for i in range(len(s)):
    if s[i] == 'A':
        a += int(s[i+1])
    elif s[i] == 'B':
        b += int(s[i+1])
print('A' if a > b else 'B')