class Solution {
    class Pair{
        int vtx;
        int cost;
        Pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
    List<List<Pair>>l1;
    public int networkDelayTime(int[][] edges, int v, int src) {
        src=src-1;
        l1=new ArrayList<>();
        for(int i=0;i<v;i++){
            l1.add(new ArrayList<Pair>());
        }
        for(int []edge:edges){
            int v1=edge[0];
            int v2=edge[1];
            int cost=edge[2];
            l1.get(v1-1).add(new Pair(v2-1,cost));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int dist[]=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            //remove
            Pair p=pq.remove();
            //ignore
            //markVisited
            //self work
            //add n
            for(Pair nbrs:l1.get(p.vtx)){
               int d=p.cost+nbrs.cost;
               if(d<dist[nbrs.vtx]){
                   dist[nbrs.vtx]=d;
                   pq.add(new Pair(nbrs.vtx,d));
               }
            }
        }int max=Integer.MIN_VALUE;
        for(int i=0;i<dist.length;i++){
            
            max=Math.max(max,dist[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}