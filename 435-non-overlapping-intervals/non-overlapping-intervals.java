class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int temp[]=intervals[0];List<int[]>l1=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(temp[1]>intervals[i][0]){
                if(temp[1]>intervals[i][1])
                temp=intervals[i];
            }
            else{
                l1.add(temp);
                temp=intervals[i];
            }
        }
        l1.add(temp);
        return intervals.length-l1.size();
    }
}