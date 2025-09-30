class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=0;int r=0;int c=0;
        while(r<nums.length){
            //map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.containsKey(nums[r])){
               map.put(nums[r],map.get(nums[r])+1);
            }
            else{
                map.put(nums[r],1);
            }
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            c+=r-l+1;
            r++;
        }
        r=0;l=0;int g=0;
        HashMap<Integer,Integer>map1=new HashMap<>();
        while(r<nums.length){
            //map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map1.containsKey(nums[r])){
               map1.put(nums[r],map1.get(nums[r])+1);
            }
            else{
                map1.put(nums[r],1);
            }
            while(map1.size()>k-1){
                map1.put(nums[l],map1.get(nums[l])-1);
                if(map1.get(nums[l])==0){
                    map1.remove(nums[l]);
                }
                l++;
            }
            g+=r-l+1;
            r++;
        }
        return c-g;
    }
}