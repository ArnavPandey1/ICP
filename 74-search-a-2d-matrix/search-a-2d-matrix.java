class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //      for(int i=0;i<matrix.length;i++){
    //         if(target>=matrix[i][0]&& target<=matrix[i][matrix[0].length-1]){
    //          boolean flag=binarysearch(matrix[i],target);
    //          if(flag==true)
    //          return true;
    //         }
    //      }    
    //      return false;
    // }
    // public boolean binarysearch(int[] arr,int target){
    //     int lb=0;int ub=arr.length-1;
    //     while(lb<=ub){
    //         int mid=lb+(ub-lb)/2;
    //         if(arr[mid]==target){
    //             return true;
    //         }
    //         else if(arr[mid]<target){
    //             lb=mid+1;
    //         }
    //         else{
    //             ub=mid-1;
    //         }
    //     }
    //     return false;
    // }
    int lb=0;int ub=matrix.length*matrix[0].length-1;
    while(lb<=ub){
        int mid=lb+(ub-lb)/2;
        if(matrix[mid/matrix[0].length][mid%matrix[0].length]==target){
            return true;
        }
        else if(target>matrix[mid/matrix[0].length][mid%matrix[0].length]){
            lb=mid+1;
        }
        else{
            ub=mid-1;
        }
    }
    return false;
}
}