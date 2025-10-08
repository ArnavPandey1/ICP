class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append("(");
        }
        for(int i=0;i<k;i++){
            sb.append(")");
        }
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb2.append(s.charAt(i));
            if(sb2.length()>=sb.length() && sb2.substring(sb2.length()-sb.length()).equals(sb.toString())){
                sb2.delete(sb2.length()-sb.length(),sb2.length());
            }
        }
        return sb2.toString();
}
}