idx = 1;
while 1:
    a, b = input(), input()
    if a == b == "END": break
    print(f"Case {idx}:", "same" if sorted(a) == sorted(b) else "different")
    idx += 1