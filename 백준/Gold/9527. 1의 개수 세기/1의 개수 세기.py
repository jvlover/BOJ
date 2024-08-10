def fun(n):
  cnt, i = 0, 0
  while 2**i <= n:
    len = 2**(i+1)
    cnt += (n+1)//len*(len//2)+max(0, (n+1)%len-len//2)
    i += 1
  return cnt

a, b = map(int, input().split())
print(fun(b)-fun(a-1))