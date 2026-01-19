class Solution {
    public boolean isValid(String str) {
        Stack<Character>st=new Stack<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='('||ch=='{'||ch=='[') {
				st.push(ch);
			}
			else {
				if(st.isEmpty()) {
					return false;
				}
				else if(ch==')' && st.peek()!='(') {
					return false;
				}
				else if(ch=='}' && st.peek()!='{') {
					return false;
				}
				else if(ch==']' && st.peek()!='[') {
					return false;
				}
                else{
                    st.pop();
                }
			}
		}
		if(!st.isEmpty()) {
			return false;
		}
		return true;
    }
}