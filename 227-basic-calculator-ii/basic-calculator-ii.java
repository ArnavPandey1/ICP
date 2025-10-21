class Solution {
    public int calculate(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", "");
        Stack<Long> nst = new Stack<>();
        Stack<Character> ost = new Stack<>();
        long r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                r = r * 10 + (ch - '0');
            } else {
                nst.push(r);
                r = 0;
                while (!ost.isEmpty() && priority(ost.peek()) >= priority(ch)) {
                    long b = nst.pop();
                    long a = nst.pop();
                    if (ost.peek() == '+')
                        nst.push(a + b);
                    else if (ost.peek() == '-')
                        nst.push(a - b);
                    else if (ost.peek() == '*')
                        nst.push(a * b);
                    else if (ost.peek() == '/')
                        nst.push(a / b);
                    ost.pop();
                }
                ost.push(ch);
            }
        }
        if(r!=-1)
        nst.push(r);
        while (!ost.isEmpty()) {
            long b = nst.pop();
            long a = nst.pop();
            if (ost.peek() == '+')
                nst.push(a + b);
            else if (ost.peek() == '-')
                nst.push(a - b);
            else if (ost.peek() == '*')
                nst.push(a * b);
            else if (ost.peek() == '/')
                nst.push(a / b);
            ost.pop();
        }
        r = nst.pop();
        return (int) r;
    }

    public static int priority(char c) {
        if (c == '*' || c == '/')
            return 1;
        else
            return 0;
    }
}