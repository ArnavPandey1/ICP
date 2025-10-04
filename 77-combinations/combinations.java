class Solution {
    static List<List<Integer>>l1=new ArrayList<>();
    static List<Integer>l2=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        int nums[]=new int[n];
        int visited[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=i+1;
        print(nums,k,l2,visited,0);  
        return l1;      
    }
    public static void print(int []nums,int k,List<Integer>l2,int []visited,int idx)
    {
        if(l2.size()==k)
        {
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            if(visited[i]==1)
            continue;
            visited[i]=1;
            l2.add(nums[i]);
            print(nums,k,l2,visited,i+1);
            visited[i]=0;
            l2.remove(l2.size()-1);
        }
    }
}