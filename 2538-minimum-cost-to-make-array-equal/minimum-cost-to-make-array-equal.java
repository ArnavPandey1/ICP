class Solution {
    public long minCost(int[] nums, int[] cost) {
        long low=nums[0];
        long high=nums[0];
        for(int i=0;i<nums.length;i++){
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }
        long ans=0;
        while(low<high){
            long mid=low+(high-low)/2;
            long c1=find(nums,cost,mid);
            long c2=find(nums,cost,mid+1);
            ans=Math.min(c1,c2);
            if(c1<=c2){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public long find(int []nums,int[] cost,long target){
        long total=0;
        for(int i=0;i<nums.length;i++){
            total+=Math.abs(nums[i]-target)*cost[i];
        }
        return total;
    }
}