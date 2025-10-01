class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r=0;int l=0;int max=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<s.length()){
           char ch=s.charAt(r);
           if(!map.containsKey(ch)){
            map.put(ch,1);
           }
           else{
            while(s.charAt(l)!=ch){
                map.remove(s.charAt(l));
                l++;
            }
            l++;
            map.remove(ch);
            map.put(s.charAt(r),1);
           }
           max=Math.max(max,r-l+1);
           r++;
        }
        return max;
    }
}