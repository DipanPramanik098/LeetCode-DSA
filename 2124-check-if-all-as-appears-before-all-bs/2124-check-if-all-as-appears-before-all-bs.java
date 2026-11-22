class Solution {
    public boolean checkString(String s) {
        boolean see_a = false;
        int n = s.length();

        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == 'a') see_a = true;

            else if(see_a == true && s.charAt(i) == 'b') return false;
        }
        return true;
    }
}