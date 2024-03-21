class Solution {
    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        return (long)w*h-gcd*(w/gcd+h/gcd-1);
    }
    long gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}