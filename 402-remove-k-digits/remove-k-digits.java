class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Character>st=new Stack<>();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && (ch-'0')<(st.peek()-'0')){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder str=new StringBuilder();
        int l=0;
        for(char c:st){
           if(l==0 && c=='0'){
              continue;
           }
           else{
            l=1;
            str.append(c);
           }
        }
        if(str.length()>=1)
        return str.toString();
        return "0";
    }
}