class Solution {
    // (u->(v,cost))
    static HashMap<Character,HashMap<Character,Integer>> map;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] tcost) {
        int n=original.length;
        // construct a directed weighted graph for all characters in original array
        map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)(i+'a'),new HashMap<>());
        }
        for(int i=0;i<n;i++){
            char u=original[i];
            char v=changed[i];
            int c=tcost[i];
            map.get(u).put(v,Math.min(c,map.get(u).getOrDefault(v,Integer.MAX_VALUE)));
        }

        // precompute all the distances for all 26*26 pairs
        // i.e. >> a to all, b to all, ...z to all
        long [][] minCost=new long[26][26];

        // compute the min distance for all
        for(int i=0;i<26;i++){
            dijkstra(minCost[i],i);
        }

        // now iterate over the original string and compute the total cost
        int len=source.length();
        long totalCost=0;
        for(int i=0;i<len;i++){
            int og=source.charAt(i)-'a';
            int tg=target.charAt(i)-'a';
            long cost=minCost[og][tg];
            // if the cost to change original char to target char is long_max, means we can't change it, so return -1 directly...
            if(cost==Long.MAX_VALUE){
                return -1;
            }
            totalCost+=cost;
        }
        return totalCost;
    }
    public static void dijkstra(long [] minCost,int src){
        Arrays.fill(minCost,Long.MAX_VALUE);
        // cost to change node to self is 0..
        minCost[src]=0;

        // create a priority queue(min heap) to process min cost..
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        pq.add(new Pair((char)(src+'a'),0));
        
        while(!pq.isEmpty()){
            // remove
            Pair p=pq.poll();
            int u=p.node-'a';

            // ignore
            if(p.cost>minCost[u]){
                continue;
            }

            // add neighbours
            for(char ch:map.get(p.node).keySet()){
                int idx=ch-'a';
                long temp=map.get(p.node).get(ch)+minCost[u];
                if(minCost[idx]>temp){
                    minCost[idx]=temp;
                    pq.add(new Pair(ch,temp));
                }
            }
        }
        return;
    }
    static class Pair{
        char node;
        long cost;
        Pair(char node,long cost){
            this.node=node;
            this.cost=cost;
        }
    }
}