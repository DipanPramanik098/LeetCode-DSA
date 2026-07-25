class Solution {
    public int maxProduct(int n) {
        int m1 = -1, m2 = -2;

        while(n>0){
            int d = n % 10;

            if(d >= m1){
                m2 = m1;
                m1 = d;
            }else if(d > m2){
                m2 = d;
            }

            n/=10;
        }
        return m1 * m2;
    }
}