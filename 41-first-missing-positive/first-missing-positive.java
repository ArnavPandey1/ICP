class Solution {
    public int firstMissingPositive(int[] nums) {
    //    HashMap<Integer,Integer>map=new HashMap<>();
    //    for(int i=0;i<nums.length;i++){
    //     map.put(nums[i],1);
    //    }
    //    for(int i=1;i<=nums.length;i++){
    //       if(!map.containsKey(i))
    //       return i;
    //    }
    //    return nums.length+1;


     int f=0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]==1)
        f=1;
        if(nums[i]<1 || nums[i]>nums.length)
        nums[i]=1;
     }
     if(f==0)
     return 1;
     for(int i=0;i<nums.length;i++){
        int v=Math.abs(nums[i]);
        if(nums[v-1]>0){
            nums[v-1]=-nums[v-1];
        }
     }
     for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            return i+1;
        }
     }
     return nums.length+1;
    }
}