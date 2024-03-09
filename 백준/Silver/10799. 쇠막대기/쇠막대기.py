s, st, ans = input(), [], 0
for i in range(len(s)):
    if s[i] == '(':
        st.append('(')
    else:
        st.pop()
        if s[i-1] == '(':
            ans += len(st)
        else:
            ans += 1
print(ans)