A, B = input().split()
for i in range(len(A)):
    if A[i] in B:
        idx = i
        w = B.index(A[i])
        break
for i in range(len(B)):
    print(A if i == w else ('.' * idx + B[i] + '.' * (len(A)-idx-1)))