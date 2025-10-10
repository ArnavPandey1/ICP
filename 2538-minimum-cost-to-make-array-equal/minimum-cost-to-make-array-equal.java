class Solution {
    public long minCost(int[] nums, int[] cost) {
        long lb=nums[0];
        long ub=nums[0];
        for(int i=0;i<nums.length;i++){
            lb=Math.min(nums[i],lb);
            ub=Math.max(nums[i],ub);
        }
        long ans=-1;
        while(lb<=ub){
            long mid=lb+(ub-lb)/2;
            long c1=cost_cal(nums,cost,mid);
            long c2=cost_cal(nums,cost,mid+1);
            ans=Math.min(c1,c2);
            if(c1<c2){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return ans;
    }
    public long cost_cal(int []nums,int[] cost,long mid){
        long total=0;
        for(int i=0;i<nums.length;i++){
            total+=Math.abs(nums[i]-mid)*cost[i];
        }
        return total;
    }
}