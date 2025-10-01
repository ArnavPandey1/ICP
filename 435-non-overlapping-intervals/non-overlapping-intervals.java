class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int temp=intervals[0][1];int c=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<temp){
                temp=Math.min(temp,intervals[i][1]);
                c++;
            }
            else{
              temp=intervals[i][1];
            }
        }
        return c;
    }
}