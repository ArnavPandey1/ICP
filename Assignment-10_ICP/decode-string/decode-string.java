class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int r = 0;
        Stack<Integer> st1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
                r = r * 10 + (ch - '0');
            else if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    sb.append(st.pop());
                }
                if (!st.isEmpty())
                    st.pop();
                int n = 0;
                if (!st1.isEmpty())
                    n = st1.pop();
                for (int j = 0; j < n; j++) {
                    st.push(sb.toString());
                }
            }
            else if(ch=='['){
                st.push("" + ch);
                st1.push(r);
                r = 0;
            }
            else{
                st.push(""+ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}