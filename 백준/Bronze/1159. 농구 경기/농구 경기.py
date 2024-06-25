p = [input()[0] for _ in range(int(input()))]
ans = ''.join(sorted(i for i in set(p) if p.count(i) >= 5))
print(ans if len(ans) > 0 else 'PREDAJA')