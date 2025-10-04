class Solution {
    static List<List<Integer>>l1=new ArrayList<>();
    static List<Integer>l2=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        print(candidates,l2,target,0,0);
        return l1;
    }
    public static void print(int[] nums,List<Integer>l2,int target,int s,int idx){
        if(s==target)
        {
            l1.add(new ArrayList<>(l2));
            return;
        }
        if(s>target)
        return;
        for(int i=idx;i<nums.length;i++)
        {
            l2.add(nums[i]);
            print(nums,l2,target,s+nums[i],i);
            l2.remove(l2.size()-1);
        }
    }
}