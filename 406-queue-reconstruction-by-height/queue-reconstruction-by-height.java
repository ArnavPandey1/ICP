class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
            return a[1]-b[1];
            return b[0]-a[0];
        });
        List<int[]>l1=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            l1.add(people[i][1],people[i]);
        }
        return l1.toArray(new int[people.length][]);
    }
}