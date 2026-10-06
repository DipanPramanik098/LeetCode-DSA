class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        int extra = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else{
                if (!st.empty()) {
                    st.pop();
                } else {
                    extra++;
                }
            }
        }

        if (extra != 0 && !st.empty()) {
            return extra + st.size();
        } else if (extra == 0) {
            return st.size();
        }

        return extra;
    }
}