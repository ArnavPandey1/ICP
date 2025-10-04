class Solution {
    static List<List<Integer>>l1=new ArrayList<>();
    static List<Integer>l2=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        int[] visited=new int[nums.length];
        print(nums,l2,visited);
        return l1;
    }
    public static void print(int []nums,List<Integer>l2,int []visited){
        if(l2.size()==nums.length){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {   
            if(visited[i]==1)
            continue;
            visited[i]=1;
            l2.add(nums[i]);
            print(nums,l2,visited);
            visited[i]=0;
            l2.remove(l2.size()-1);
        }
    }
}