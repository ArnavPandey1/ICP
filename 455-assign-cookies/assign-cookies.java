class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;int l=0;
        while(i<g.length && l<s.length){
            if(g[i]<=s[l]){
               i++;
            }
           l++;
        }
        return i;
    }
}