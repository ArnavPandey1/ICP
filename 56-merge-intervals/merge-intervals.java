class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int temp[]=intervals[0];int c=0;
        List<int[]>l1=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=temp[1]){
                temp[1]=Math.max(temp[1],intervals[i][1]);
            }
            else{
              l1.add(temp);
              temp=intervals[i];
            }
        }
        l1.add(temp);
        int ans[][]=new int[l1.size()][2];
        for(int i=0;i<l1.size();i++){
            ans[i]=l1.get(i);
        }
        return ans;
    }
}