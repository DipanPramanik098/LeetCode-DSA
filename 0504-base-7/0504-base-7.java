class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";

        int original = num;
        num = Math.abs(num);
        StringBuilder ans = new StringBuilder();

        while(num > 0){
            int r = num % 7;
            ans.append(r);
            num/=7;
        }
        if(original < 0) {
            ans.append('-');
        }

        return ans.reverse().toString();
    }
}