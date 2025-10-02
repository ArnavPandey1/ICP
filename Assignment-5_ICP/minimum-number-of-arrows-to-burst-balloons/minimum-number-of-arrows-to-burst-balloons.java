class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int temp=points[0][1];List<Integer>l1=new ArrayList<>();
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=temp){
                temp=Math.min(temp,points[i][1]);
            }
            else{
                l1.add(temp);
                temp=points[i][1];
            }
        }
        l1.add(temp);
        return l1.size();
    }
}