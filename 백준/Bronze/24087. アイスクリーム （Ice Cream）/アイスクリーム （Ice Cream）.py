import math
s, a, b = int(input()), int(input()), int(input())
print(250 if s-a < 0 else 250+(math.ceil((s-a)/b)*100))