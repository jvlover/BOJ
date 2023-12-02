input()
s = input()
ans = 'Yes'
now = s[0]
for i in range(2, len(s), 2):
    if now != s[i]:
        ans = 'No'
        break
    now = s[i]
print(ans)