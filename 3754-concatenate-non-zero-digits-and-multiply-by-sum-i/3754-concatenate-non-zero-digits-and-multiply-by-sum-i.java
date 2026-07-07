class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long val = 0;
        long demo = 1;
        while(n>0){
            if(n%10 != 0){
                sum += (n%10);
                val = (n%10)*demo + val;
                demo*=10;
            }
            n/=10;
        }
        return sum*val;
    }
}