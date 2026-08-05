class Solution {
    public int maxProfit(int[] a) {
        int p = 0;
        int n = a.length;
        for(int i=1; i<n; i++){
            if(a[i-1]<a[i]){
                p += (a[i] - a[i-1]);
            }
        }
        return p;
    }
}