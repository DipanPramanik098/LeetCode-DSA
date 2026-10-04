class Solution {
    public boolean checkValidString(String s) {
        int min_possible_open = 0;
        int max_possible_open = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                min_possible_open++;
                max_possible_open++;
            }else if(ch == ')'){
                min_possible_open--;
                max_possible_open--;
            }else{
                // the * case
                // * jodi ( hoy tobe maxOpen barbe r jodi ) hoy tobe minOpen kombr
                min_possible_open--;
                max_possible_open++;
            }

            if(max_possible_open < 0){ // mane # ) > # (
                return false;
            }

            min_possible_open = Math.max(min_possible_open, 0);
        }
        return min_possible_open == 0;
    }
}