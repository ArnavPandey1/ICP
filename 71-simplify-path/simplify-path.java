class Solution {
    public String simplifyPath(String path) {
        int i = 0;
        Stack<String> st = new Stack<>();
        while (i < path.length()) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (st.isEmpty() || st.peek() != "/")
                    st.push("/");
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i));
                    i++;
                }
                if (sb.length() == 1 && sb.charAt(0) == '.') {
                    continue;
                } else if (sb.length() == 2 && sb.toString().equals("..")) {
                    while(!st.isEmpty() && st.peek()=="/")
                    st.pop();
                    while(!st.isEmpty() && st.peek()!="/")
                    st.pop();
                    if(!st.isEmpty())
                    st.pop();

                } else {
                    st.push(sb.toString());
                }
            }
        }
        if (!st.isEmpty()&&st.peek() == "/")
            st.pop();
        StringBuilder s = new StringBuilder();
        for (String c : st) {
            s.append(c);
        }
        return s.length()==0?"/":s.toString();
    }
}