class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]=new int[nums2.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        Stack<Integer>st =new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                ans[st.pop()]=nums2[i];
            }
            st.push(i);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],ans[i]);
        }
        int arr[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=map.get(nums1[i]);
        }
        return arr;
    }
}