class Solution {
    private int product(int x) {
        int p = 1;
        while (x > 0) {
            p *= x % 10;
            x /= 10;
        }
        return p;
    }

    public int smallestNumber(int n, int t) {
        while (true) {
            if (product(n) % t == 0) {
                return n;
            }
            n++;
        }
    }
}
