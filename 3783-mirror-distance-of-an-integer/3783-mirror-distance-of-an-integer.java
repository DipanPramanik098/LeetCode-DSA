class Solution {
    public int rev(int n){
        int num = n;
        int revNum = 0;
        while(num > 0){
            int ld = num % 10;
            revNum = revNum * 10 + ld;
            num/=10;
        }
        return revNum;
    }
    public int mirrorDistance(int n) {
        int demo = rev(n);
        return Math.abs(n - demo);
    }
}