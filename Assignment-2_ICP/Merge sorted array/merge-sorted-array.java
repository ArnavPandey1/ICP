class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int ans[]=new int[m+n];
        // int i=0;int j=0;int c=0;
        // while(i<m&&j<n){
        //     if(nums1[i]>nums2[j]){
        //        ans[c++]=nums2[j];
        //        j++;
        //     }
        //     else if(nums1[i]<nums2[j]){
        //         ans[c++]=nums1[i];
        //         i++;
        //     }
        //     else{
        //        ans[c++]=nums2[j];
        //        j++;
        //        ans[c++]=nums1[i];
        //         i++;
        //     }
        // }
        // while(i<m){
        //         ans[c++]=nums1[i];
        //         i++;
        // }
        // while(j<n){
        //         ans[c++]=nums2[j];
        //         j++;
        // }
        // for(int k=0;k<ans.length;k++){
        //     nums1[k]=ans[k];
        // }

         int i=m-1;int j=n-1;int k=nums1.length-1;
         while(i>=0 && j>=0){
             if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i];
                i--;
             }
             else{
                 nums1[k--]=nums2[j];
                 j--;
             }
         }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }
}
/*
Time Complexity: O(m + n)
Space Complexity: O(1)
    */
