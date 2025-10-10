class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<secret.length();i++){
            char ch=secret.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ctA=0;
        int ctB=0;
        boolean [] visited=new boolean[guess.length()];
        for(int i=0;i<guess.length();i++){
            char ch=guess.charAt(i);
            if(ch==secret.charAt(i)){
                ctA++;
                visited[i]=true;
                map.put(ch,map.get(ch)-1);
            }
        }
        for(int i=0;i<guess.length();i++){
            char ch=guess.charAt(i);
            if(!visited[i] && map.containsKey(ch) && map.get(ch)>0){
                ctB++;
                map.put(ch,map.get(ch)-1);                    
            }
        }
        
        return ctA+"A"+ctB+"B";
    }
}